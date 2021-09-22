package com.example.car.xport.rest.events;

import com.example.car.services.CarService;
import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import com.example.sharedkernel.domain.events.rents.RentedCarCreated;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarEventListener {

    private final CarService carService;

    @KafkaListener(topics = TopicHolder.TOPIC_RENTED_CAR_CREATED, groupId = "car")
    public void consumeRentedCarCreatedEvent(String jsonMessage) {
        try {
            RentedCarCreated event = DomainEvent.fromJson(jsonMessage, RentedCarCreated.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
