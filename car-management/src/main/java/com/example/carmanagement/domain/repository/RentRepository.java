package com.example.carmanagement.domain.repository;

import com.example.carmanagement.domain.model.Rent;
import com.example.carmanagement.domain.model.RentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, RentId> {
}
