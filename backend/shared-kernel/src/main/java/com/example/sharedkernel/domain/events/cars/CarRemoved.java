package com.example.sharedkernel.domain.events.cars;

import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class CarRemoved extends DomainEvent {

    public CarRemoved(String topic, String data) {
        super(topic, data);
    }
}
