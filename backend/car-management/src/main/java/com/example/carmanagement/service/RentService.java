package com.example.carmanagement.service;

import com.example.carmanagement.domain.exceptions.RentIdException;
import com.example.carmanagement.domain.exceptions.RentedCarIdException;

import com.example.carmanagement.domain.model.RentedCar;
import com.example.carmanagement.domain.model.RentedCarId;
import com.example.carmanagement.service.forms.RentedCarForm;


import java.util.List;
import java.util.Optional;

public interface RentService {
    RentedCarId placeRent(RentedCarForm rentForm);
    List<RentedCar> findAll();
    Optional<RentedCar> findById(RentedCarId rentId);
    List<RentedCar> findByUser(String id);
//    void addRent(RentedCarId rentId, RentedCarForm rentedCarForm) throws RentIdException;
    void deleteRent(RentedCarId rentId, RentedCarId rentedCarId) throws RentIdException, RentedCarIdException;
}
