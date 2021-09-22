package com.example.carmanagement.service.impl;

import com.example.carmanagement.domain.exceptions.InvalidDateException;
import com.example.carmanagement.domain.exceptions.RentIdException;
import com.example.carmanagement.domain.exceptions.RentedCarIdException;
import com.example.carmanagement.domain.model.Rent;
import com.example.carmanagement.domain.model.RentId;
import com.example.carmanagement.domain.model.RentedCarId;
import com.example.carmanagement.domain.repository.RentRepository;
import com.example.carmanagement.service.RentService;
import com.example.carmanagement.service.forms.RentForm;
import com.example.carmanagement.service.forms.RentedCarForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;

    private final Validator validator;

    @Override
    public RentId placeRent(RentForm rentForm) {
        Objects.requireNonNull(rentForm, "cannot be null");
        var violations = validator.validate(rentForm);
        if (violations.size() > 0)
            throw new ConstraintViolationException("rent not valid!", violations);
        var newRent = rentRepository.saveAndFlush(toDomainObject(rentForm));
        return newRent.getId();
    }

    private Rent toDomainObject(RentForm rentForm) {
        var rent = new Rent(LocalDateTime.now(), rentForm.getCurrency(), rentForm.getUser().getId());
        rentForm.getItems().forEach(r -> rent.addCar(r.getCar(), r.getUser(), r.getFrom(), r.getTo(), r.getDays()));
        return rent;
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Optional<Rent> findById(RentId rentId) {
        return rentRepository.findById(rentId);
    }

    @Override
    public void addCar(RentId rentId, RentedCarForm rentedCarForm) throws RentIdException {
        Rent rent = rentRepository.findById(rentId).orElseThrow(RentIdException::new);
        findAll().forEach(r -> r.getAllRentedCars().forEach(c -> {
            if(!checkDates(c.getFrom(), c.getTo(), rentedCarForm))
                throw new InvalidDateException();
        }));
        rent.addCar(rentedCarForm.getCar(), rentedCarForm.getUser(), rentedCarForm.getFrom(), rentedCarForm.getTo(), rentedCarForm.getDays());
        rentRepository.saveAndFlush(rent);
    }

    private boolean checkDates(LocalDateTime f, LocalDateTime t, RentedCarForm rf) {
        return (rf.getFrom().isBefore(f) && rf.getTo().isBefore(t)) || (rf.getFrom().isAfter(f) && rf.getTo().isAfter(t));
    }

    @Override
    public void deleteCar(RentId rentId, RentedCarId rentedCarId) throws RentIdException, RentedCarIdException {
        Rent rent = rentRepository.findById(rentId).orElseThrow(RentIdException::new);
        rent.removeCar(rentedCarId);
        rentRepository.saveAndFlush(rent);
    }
}
