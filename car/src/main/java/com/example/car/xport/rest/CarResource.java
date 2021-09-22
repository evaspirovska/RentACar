package com.example.car.xport.rest;

import com.example.car.domain.models.Car;
import com.example.car.domain.models.CarId;
import com.example.car.services.CarService;
import com.example.car.services.form.CarForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addProduct")
    public Car addProduct(@RequestBody CarForm carForm) {
        return carService.createCar(carForm);
    }

    @GetMapping("/getById/{id}")
    public Car findProductById(@PathVariable int id) {
        return carService.findById(CarId.of(String.valueOf(id)));
    }


    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        carService.deleteById(CarId.of(String.valueOf(id)));
    }
}
