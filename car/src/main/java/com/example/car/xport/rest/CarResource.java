package com.example.car.xport.rest;

import com.example.car.domain.models.Car;
import com.example.car.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarResource {

    private final CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }
}
