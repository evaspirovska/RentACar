package com.example.carmanagement.domain.repository;

import com.example.carmanagement.domain.model.RentedCar;
import com.example.carmanagement.domain.model.RentedCarId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<RentedCar, RentedCarId> {
    List<RentedCar> findByUserId(String id);
}
