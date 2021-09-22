package com.example.user.service;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import com.example.user.service.forms.UserForm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll();
    User findById(UserId userId);
    User createUser(UserForm userForm);
    void deleteUser(UserId userId);
    User findByEmail(String email);
    UserId register(UserForm userForm);
}
