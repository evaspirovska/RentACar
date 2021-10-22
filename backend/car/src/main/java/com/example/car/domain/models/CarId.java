package com.example.car.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;


public class CarId extends DomainObjectId {

    private CarId() {
        super(CarId.randomId(CarId.class).getId());
    }

    public CarId(@NonNull String uuid) {
        super(uuid);
    }

    public static CarId of(String uuid) {
        CarId c = new CarId(uuid);
        return c;
    }
}
