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

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car findById(CarId carId) {
        return carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
    }

    @Override
    public Car createCar(CarForm form) {
        Car c = Car.build(form.getName(), form.getDescription(), form.getLocation(), form.getPrice());
        carRepository.save(c);
        return c;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
