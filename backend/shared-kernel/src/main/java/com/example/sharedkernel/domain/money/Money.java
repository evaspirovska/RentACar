package com.example.sharedkernel.domain.money;

import com.example.sharedkernel.domain.base.ValueObject;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;


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

    public static Money valueOf(Currency currency, double ammount) {
        return new Money(currency, ammount);
    }

    public Money add(Money money) {

        if(!currency.equals(money.currency))
            throw new IllegalArgumentException("Different currencies!");
        return new Money(currency, ammount + money.ammount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.ammount, ammount) == 0 &&
                currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, ammount);
    }

//    public Money substract(Money money) {
//
//        if(!currency.equals(money.currency))
//            throw new IllegalArgumentException("Different currencies!");
//        return new Money(currency, ammount - money.ammount);
//    }

    public Money multiply(int m) {
        return new Money(currency, ammount * m);
    }

    public Money change(Currency from, Currency to, double ammount) {

        if(from.name().equals("USD") && to.name().equals("MKD"))
            return new Money(to, ammount);
        else if(from.name().equals("USD") && to.name().equals("EUR"))
            return new Money(to, ammount);
        else if(from.name().equals("EUR") && to.name().equals("MKD"))
            return new Money(to, ammount);
        else if(from.name().equals("EUR") && to.name().equals("USD"))
            return new Money(to, ammount);
        else if(from.name().equals("MKD") && to.name().equals("USD"))
            return new Money(to, ammount);
        else
            return new Money(to, ammount);
    }
}
