package com.example.carmanagement.service;

import com.example.carmanagement.domain.exceptions.RentIdException;
import com.example.carmanagement.domain.exceptions.RentedCarIdException;
import com.example.carmanagement.domain.model.Rent;
import com.example.carmanagement.domain.model.RentId;
import com.example.carmanagement.domain.model.RentedCarId;
import com.example.carmanagement.service.forms.RentForm;
import com.example.carmanagement.service.forms.RentedCarForm;

import java.util.List;
import java.util.Optional;

public interface RentService {
    RentId placeRent(RentForm rentForm);
    List<Rent> findAll();
    Optional<Rent> findById(RentId rentId);
    void addCar(RentId rentId, RentedCarForm rentedCarForm) throws RentIdException;
    void deleteCar(RentId rentId, RentedCarId rentedCarId) throws RentIdException, RentedCarIdException;
}
