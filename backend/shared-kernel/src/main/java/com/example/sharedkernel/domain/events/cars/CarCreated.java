package com.example.sharedkernel.domain.events.cars;

import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class CarCreated extends DomainEvent {

    public CarCreated(String topic, String data) {
        super(topic, data);
    }
}
