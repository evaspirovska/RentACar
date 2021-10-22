package com.example.sharedkernel.domain.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.time.Instant;

@Getter
public class DomainEvent {

    private String topic;
    private String jasonData;
    private Instant occurredOn;

    public DomainEvent(String topic, String jsonData) {
        this.occurredOn = Instant.now();
        this.jasonData = jsonData;
        this.topic = topic;
    }

    public String topic() {
        return topic;
    }

    public static <E extends DomainEvent> E fromJson(String json, Class<E> eventClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json,eventClass);
    }

}
