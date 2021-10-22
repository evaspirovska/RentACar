package com.example.car.services.form;

import com.example.car.domain.valueobjects.CarStatus;
import com.example.sharedkernel.domain.money.Money;
import lombok.Data;

@Data
public class CarForm {

    private String name;
    private String description;
    private Money price;
    private String location;
//    private CarId carId;
    private CarStatus carStatus;

    public CarForm(String name, String description, Money price, String location, CarStatus carStatus) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.location = location;
//        this.carId = carId;
        this.carStatus = carStatus;
    }
}
