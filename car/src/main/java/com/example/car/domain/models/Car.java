package com.example.car.domain.models;


//import com.example.car.domain.valueobjects.Dates;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car extends AbstractEntity<CarId> {

//    price, description, total rate, name, free dates

    private String name;
    private String description;
    @AttributeOverrides({
            @AttributeOverride(name="ammount", column = @Column(name="price_ammount")),
            @AttributeOverride(name="currency", column = @Column(name = "price_currency"))
    })
    private Money price;
    private String location;
    private double rate;

}
