package com.example.carmanagement.rest;

import com.example.carmanagement.domain.model.RentedCar;
import com.example.carmanagement.domain.model.RentedCarId;
import com.example.carmanagement.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9092")
@RequestMapping("/api")
@AllArgsConstructor
public class RentRestController {

    private final RentService rentService;

    @GetMapping("/rent/{id}")
    public RentedCar getRentalById(@PathVariable String id){
        return rentService.findById(RentedCarId.of(id)).get();
    }

    @GetMapping("/rents")
    public List<RentedCar> getAllRents(){
        return rentService.findAll();
    }

    @GetMapping("/userRents")
    public List<RentedCar> getAllUserRents(@PathVariable String id){
        return rentService.findByUser(id);
    }
}
