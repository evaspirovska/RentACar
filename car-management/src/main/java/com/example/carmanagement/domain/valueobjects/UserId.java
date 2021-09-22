package com.example.carmanagement.domain.valueobjects;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {

    protected UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid) {
        super(uuid);
    }

}
