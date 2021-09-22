package com.example.carmanagement.domain.valueobjects;

import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class User implements ValueObject {

    private final UserId id;
    private final String username;

    public User() {
        this.id = UserId.randomId(UserId.class);
        this.username = "";
    }

    @JsonCreator
    public User(UserId id, String username) {
        this.id = id;
        this.username = username;
    }
}
