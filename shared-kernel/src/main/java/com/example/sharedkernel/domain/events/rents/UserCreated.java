package com.example.sharedkernel.domain.events.rents;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserCreated extends DomainEvent {

    String username;
    String password;
    String email;
    String telephone;

    public UserCreated(String topic) {
        super(TopicHolder.TOPIC_USER_CREATED);
    }

    public UserCreated(String username, String password, String email, String telephone) {
        super(TopicHolder.TOPIC_USER_CREATED);
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
    }
}
