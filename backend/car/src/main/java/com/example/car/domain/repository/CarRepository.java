package com.example.car.domain.repository;

import com.example.car.domain.models.Car;
import com.example.car.domain.models.CarId;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, CarId> {

    List<Car> findAllByCarStatus_NotReserved();
}
