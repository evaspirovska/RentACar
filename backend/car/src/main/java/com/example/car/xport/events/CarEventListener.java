package com.example.car.xport.events;

import com.example.car.domain.models.CarId;
import com.example.car.services.CarService;
import com.example.car.services.form.CarForm;
import com.example.sharedkernel.domain.config.TopicHolder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarEventListener {

    private final CarService carService;

    @KafkaListener(topics = TopicHolder.TOPIC_CAR_CREATED, groupId = "json")
    public void consumeRentedCarCreatedEvent(String jsonMessage) {
        ObjectMapper mapper = new ObjectMapper();
        CarForm form;
        try {
            form = mapper.readValue(jsonMessage, CarForm.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        carService.createCar(form);
    }

    @KafkaListener(topics = TopicHolder.TOPIC_CAR_RENTED, groupId = "json")
    public void consumeRentCarEvent(String jsonMessage){

        carService.rentCar(CarId.of(getString(jsonMessage)));
    }

    @KafkaListener(topics = TopicHolder.TOPIC_CAR_REMOVED, groupId = "json")
    public void consumeFreeCarEvent(String jsonMessage){

        carService.endRent(CarId.of(getString(jsonMessage)));
    }

    private String getString(String message) {

        return message.substring(0, message.length()-1);
    }
}
