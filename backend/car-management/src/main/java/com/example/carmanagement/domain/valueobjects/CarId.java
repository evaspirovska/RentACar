package com.example.carmanagement.domain.valueobjects;

import com.example.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CarId extends DomainObjectId {

    private CarId() {
        super(CarId.randomId(CarId.class).getId());
    }

    public CarId(String uuid) {
        super(uuid);
    }
}
