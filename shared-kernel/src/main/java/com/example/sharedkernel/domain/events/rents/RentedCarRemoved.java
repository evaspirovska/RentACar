package com.example.sharedkernel.domain.events.rents;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentedCarRemoved extends DomainEvent {

    private String carId;
    private LocalDateTime from;
    private LocalDateTime to;
    private int days;

    public RentedCarRemoved(String topic) {
        super(TopicHolder.TOPIC_RENTED_CAR_REMOVED);
    }

    public RentedCarRemoved(String topic, String carId, LocalDateTime from, LocalDateTime to, int days) {
        super(TopicHolder.TOPIC_RENTED_CAR_REMOVED);
        this.carId = carId;
        this.from = from;
        this.to = to;
        this.days = days;
    }
}
