package com.example.user.service.impl;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import com.example.user.domain.model.exception.EmailTakenException;
import com.example.user.domain.model.exception.UsernameNotFoundException;
import com.example.user.domain.repostiory.UserRepository;
import com.example.user.service.UserService;
import com.example.user.service.forms.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UserId userId) {
        return userRepository.getById(userId);
    }

    @Override
    public User createUser(UserForm userForm) {
        User u = User.create(userForm.getUsername(), userForm.getPassword(), userForm.getEmail(), userForm.getTelephone());
        userRepository.saveAndFlush(u);
        return u;
    }

    @Override
    public void deleteUser(UserId userId) {
        userRepository.delete(findById(userId));
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        Optional<User> user = userRepository.findByEmail(s);
        if (user.isEmpty())
            return null;
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(),
                List.of(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_USER")}));
    }

    @Override
    public UserId register(UserForm userForm)
    {
        Objects.requireNonNull(userForm, "cannot be null");
        var constraintViolations = validator.validate(userForm);
        if (constraintViolations.size() > 0)
            throw new ConstraintViolationException("form not valid", constraintViolations);
        if (userRepository.findByEmail(userForm.getEmail()).isPresent())
            throw new EmailTakenException();
        User newUser = userRepository.saveAndFlush(createUser(userForm));
        return newUser.getId();
    }


}
