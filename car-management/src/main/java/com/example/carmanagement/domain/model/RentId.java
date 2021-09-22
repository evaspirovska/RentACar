package com.example.carmanagement.domain.model;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;


public class RentId extends DomainObjectId {

    private RentId() {
        super(RentId.randomId(RentId.class).getId());
    }

    public RentId(@NonNull String uuid) {
        super(uuid);
    }
}
