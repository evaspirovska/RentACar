package com.example.user.domain.model;

import com.example.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class UserId extends DomainObjectId {

    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid) {
        super(uuid);
    }

    public static UserId of(String uuid) {
        UserId u = new UserId(uuid);
        return u;
    }
}
