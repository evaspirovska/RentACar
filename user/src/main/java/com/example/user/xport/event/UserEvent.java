package com.example.user.xport.event;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import com.example.sharedkernel.domain.events.rents.UserCreated;
import com.example.sharedkernel.domain.events.rents.UserDeleted;
import com.example.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserEvent {

    private final UserService userService;

    @KafkaListener(topics = TopicHolder.TOPIC_USER_CREATED, groupId = "user")
    public void consumeUserCreatedEvent(String jsonMessage)
    {
        try
        {
            UserCreated userCreated = DomainEvent.fromJson(jsonMessage, UserCreated.class);
        }
        catch (Exception e)
        {}
    }

    @KafkaListener(topics = TopicHolder.TOPIC_USER_DELETED, groupId = "user")
    public void consumeUserDeletedEvent(String jsonMessage)
    {
        try
        {
            UserDeleted userDeleted = DomainEvent.fromJson(jsonMessage, UserDeleted.class);
        }
        catch (Exception e)
        {}
    }

}
