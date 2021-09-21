package com.example.sharedkernel.domain.financial;

import com.example.sharedkernel.domain.base.ValueObject;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


// ovaa klasa pretstavuva vrednosen objekt
@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private final Currency currency;
    private final double ammount;

    protected Money() {
        this.currency = null;
        this.ammount = 0.0;
    }

    public Money(@NonNull Currency currency, @NonNull double ammount) {
        this.currency = currency;
        this.ammount = ammount;
    }

    public static Money valueOd(Currency currency, double ammount) {
        return new Money(currency, ammount);
    }

    public Money add(Money money) {

        if(!currency.equals(money.currency))
            throw new IllegalArgumentException("Different currencies!");
        return new Money(currency, ammount + money.ammount);
    }

    public Money substract(Money money) {

        if(!currency.equals(money.currency))
            throw new IllegalArgumentException("Different currencies!");
        return new Money(currency, ammount - money.ammount);
    }

    public Money multiply(int m) {
        return new Money(currency, ammount * m);
    }
}
