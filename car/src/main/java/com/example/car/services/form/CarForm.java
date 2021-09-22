package com.example.car.services.form;

import com.example.sharedkernel.domain.financial.Money;
import lombok.Data;

@Data
public class CarForm {

    private String name;
    private String description;
    private Money price;
    private String location;
}
