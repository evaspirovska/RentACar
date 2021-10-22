package com.example.sharedkernel.domain.events.cars;

import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class CarRented extends DomainEvent {

    public CarRented(String topic, String data) {
        super(topic, data);
    }
}
