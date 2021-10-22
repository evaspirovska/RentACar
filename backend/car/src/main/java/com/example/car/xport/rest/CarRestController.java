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
public class CarRestController {

    private final CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @PostMapping("/addCar")
    public Car addCar(@RequestBody CarForm carForm) {
        return carService.createCar(carForm);
    }

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable String id) {
        return carService.findById(CarId.of(String.valueOf(id)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleteById(CarId.of(String.valueOf(id)));
    }

    @PostMapping("/endRent")
    public void endCarRentById(@RequestBody String id){
        carService.endRent(CarId.of(id));
    }

    @PostMapping("/startRent")
    public void startCarRentById(@RequestBody String id){
        carService.rentCar(CarId.of(id));
    }

    @PostMapping("/endRent")
    public void editCar(@RequestBody String id){
        Car c = this.findCarById(id);
        CarForm carForm = new CarForm(c.getName(), c.getDescription(), c.getPrice(), c.getLocation(), c.getCarStatus());
        carService.editCar(carForm);
    }

}
