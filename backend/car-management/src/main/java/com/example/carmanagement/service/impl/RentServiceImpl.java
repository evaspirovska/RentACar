package com.example.carmanagement.service.impl;

import com.example.carmanagement.domain.exceptions.RentIdException;
import com.example.carmanagement.domain.exceptions.RentedCarIdException;

import com.example.carmanagement.domain.model.RentedCar;
import com.example.carmanagement.domain.model.RentedCarId;
import com.example.carmanagement.domain.repository.RentRepository;
import com.example.carmanagement.domain.valueobjects.Car;
import com.example.carmanagement.domain.valueobjects.ReservationPeriod;
import com.example.carmanagement.service.RentService;
import com.example.carmanagement.service.forms.RentedCarForm;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    private final RestTemplate template;
    private final Validator validator;

    @Override
    public RentedCarId placeRent(RentedCarForm rentForm) {

        Objects.requireNonNull(rentForm, "cannot be null");
        var violations = validator.validate(rentForm);
        if (violations.size() > 0)
            throw new ConstraintViolationException("rent not valid!", violations);
        var newRent = rentRepository.saveAndFlush(toDomainObject(rentForm));
        return newRent.getId();
    }

    private RentedCar toDomainObject(RentedCarForm rentalForm){
        Car car;

        try {
            car = template.exchange(url().path("/car/" + rentalForm.getCarId().getId()).build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<Car>() {
            }).getBody();
        }
        catch (Exception e){
            return null;
        }

        return new RentedCar(rentalForm.getCarId(), rentalForm.getUserId(),
                new ReservationPeriod(rentalForm.getFrom(), rentalForm.getTo()),
                car.getPrice());
    }

    @Override
    public List<RentedCar> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Optional<RentedCar> findById(RentedCarId rentId) {
        return rentRepository.findById(rentId);
    }

    @Override
    public List<RentedCar> findByUser(String id) {
        return rentRepository.findByUserId(id);
    }

    private UriComponentsBuilder url() {
        return UriComponentsBuilder.fromUriString("http://localhost:9091/api");
    }

    @Override
    public void deleteRent(RentedCarId rentId, RentedCarId rentedCarId) throws RentIdException, RentedCarIdException {
        rentRepository.findById(rentId).get().removeRent();
    }
}
