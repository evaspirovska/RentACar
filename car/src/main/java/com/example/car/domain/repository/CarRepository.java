package com.example.car.domain.repository;

import com.example.car.domain.models.Car;
import com.example.car.domain.models.CarId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, CarId> {
}
