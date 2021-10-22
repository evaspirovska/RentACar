package com.example.car.services.impl;

import com.example.car.domain.exceptions.CarNotFoundException;
import com.example.car.domain.models.Car;
import com.example.car.domain.models.CarId;
import com.example.car.domain.repository.CarRepository;
import com.example.car.services.CarService;
import com.example.car.services.form.CarForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final Validator validator;

    @Override
    public Car findById(CarId carId) {
        return carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
    }

    @Override
    public Car createCar(CarForm form) {
        Objects.requireNonNull(form, "Vehicle must not be null!");
        var violations = validator.validate(form);
        if (violations.size()>0)
            throw new ConstraintViolationException("not valid!", violations);
        Car car = Car.build(form.getName(), form.getDescription(), form.getLocation(), form.getPrice());
        carRepository.saveAndFlush(car);
        return car;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void deleteById(CarId carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public Car editCar(CarForm form) {
        Car c = carRepository.findById(form.getCarId()).orElseThrow(CarNotFoundException::new);
        c.setParametars(form);
        carRepository.save(c);
        return c;
    }

    @Override
    public void rentCar(CarId carId) {
        Car car = this.findById(carId);
        car.rentCar();
        carRepository.save(car);
    }

    @Override
    public void endRent(CarId carId) {
        Car car = this.findById(carId);
        car.endRent();
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllNotReserved() {
        return carRepository.findAllByCarStatus_NotReserved();
    }
}
