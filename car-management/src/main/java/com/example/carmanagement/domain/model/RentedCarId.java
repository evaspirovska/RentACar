package com.example.carmanagement.domain.model;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;


public class RentedCarId extends DomainObjectId {

    private RentedCarId() {
        super(RentedCarId.randomId(RentedCarId.class).getId());
    }

    public RentedCarId(@NonNull String uuid) {
        super(uuid);
    }
}
