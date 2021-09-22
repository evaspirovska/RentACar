package com.example.user.config;

import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.example.user.domain.model.User;
import com.example.user.domain.repostiory.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;

    @PostConstruct
    public void initData() {
        User user1 = User.create("username 1", "password 1", "email 1",   "telephone 1");
        User user2 = User.create("username 2", "password 2", "email 2",   "telephone 2");
        if(userRepository.findAll().isEmpty()) {
            userRepository.saveAll(Arrays.asList(user1, user2));
        }
    }
}
