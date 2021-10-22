package com.example.car.domain.models;


//import com.example.car.domain.valueobjects.Dates;
import com.example.car.domain.valueobjects.CarStatus;
import com.example.car.services.form.CarForm;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.money.Money;
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
    private CarStatus carStatus;

    protected Car() {
        super(CarId.randomId(CarId.class));
    }

    public void setParametars(CarForm carForm) {
        this.description = carForm.getDescription();
        this.location = carForm.getLocation();;
        this.name = carForm.getName();;
        this.price = carForm.getPrice();;
        this.carStatus = carForm.getCarStatus();
    }

    public static Car build(String name, String description, String location, Money price) {
        Car c = new Car();
        c.description = description;
        c.location = location;
        c.name = name;
        c.price = price;
        c.carStatus = CarStatus.NOT_RESERVED;
        return c;
    }

    public void rentCar() {
        carStatus = CarStatus.RESERVED;
    }

    public void endRent() {
        carStatus = CarStatus.NOT_RESERVED;
    }
}
