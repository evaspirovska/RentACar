package com.example.sharedkernel.domain.events.rents;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class UserDeleted extends DomainEvent {

    String username;
    String password;
    String email;
    String telephone;

    public UserDeleted(String topic) {
        super(TopicHolder.TOPIC_USER_DELETED);
    }

    public UserDeleted(String username, String password, String email, String telephone) {
        super(TopicHolder.TOPIC_USER_DELETED);
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
    }
}
