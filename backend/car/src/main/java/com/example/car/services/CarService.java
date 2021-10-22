package com.example.car.services;

import com.example.car.domain.models.Car;
import com.example.car.domain.models.CarId;
import com.example.car.services.form.CarForm;

import java.time.LocalDateTime;
import java.util.List;

public interface CarService {
    Car findById(CarId carId);
    Car createCar(CarForm form);
    List<Car> getAll();
    void deleteById(CarId carId);
    Car editCar(CarForm form);
    void rentCar(CarId carId);
    void endRent(CarId carId);
    List<Car> getAllNotReserved();
}
