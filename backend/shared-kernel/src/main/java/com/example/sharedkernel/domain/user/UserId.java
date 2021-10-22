package com.example.sharedkernel.domain.user;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class UserId extends DomainObjectId {
    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid) {
        super(uuid);
    }

    public static UserId of(String uuid){
        return new UserId(uuid);
    }
}