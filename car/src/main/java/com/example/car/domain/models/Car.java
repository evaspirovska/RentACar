package com.example.car.domain.models;


//import com.example.car.domain.valueobjects.Dates;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Getter
public class Car extends AbstractEntity<CarId> {

//    price, description, location, name

    private String name;
    private String description;
    @AttributeOverrides({
            @AttributeOverride(name="ammount", column = @Column(name="price_ammount")),
            @AttributeOverride(name="currency", column = @Column(name = "price_currency"))
    })
    private Money price;
    private String location;
//    private double rate;

    protected Car() {
        super(CarId.randomId(CarId.class));
    }

    public static Car build(String name, String description, String location, Money price) {
        Car c = new Car();
        c.description = description;
        c.location = location;
        c.name = name;
        c.price = price;
        return c;
    }
}
