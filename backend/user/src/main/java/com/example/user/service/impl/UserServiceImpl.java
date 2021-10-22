package com.example.user.service.impl;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import com.example.user.domain.model.exception.EmailTakenException;
import com.example.user.domain.model.exception.UsernameNotFoundException;
import com.example.user.domain.repostiory.UserRepository;
import com.example.user.service.UserService;
import com.example.user.service.forms.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

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
        User u = User.create(userForm.getUsername(), userForm.getPassword(), userForm.getEmail(), userForm.getTelephone(), userForm.getRole());
        userRepository.saveAndFlush(u);
        return u;
    }

    @Override
    public void deleteUser(UserId userId) {
        userRepository.delete(findById(userId));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UsernameNotFoundException::new);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UsernameNotFoundException::new);
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
    public User register(String username, String password)
    {
        User user = this.findByUsername(username);
        if (username.isEmpty() || password.isEmpty() || passwordEncoder.matches(password, user.getPassword()))
            throw new BadCredentialsException("bad credentials!");

        return user;
    }

    @Override
    public User login(String username, String password) {

        User user = this.findByUsername(username);
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException();
        }
        return user;
    }


}
