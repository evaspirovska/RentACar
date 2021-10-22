package com.example.carmanagement.domain.valueobjects;

import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.money.Currency;
import com.example.sharedkernel.domain.money.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Car implements ValueObject {

    private final CarId id;
    private final String name;
    private final Money price;

    public Car() {
        this.id = CarId.randomId(CarId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, 0);
    }

    @JsonCreator
    public Car(CarId id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
