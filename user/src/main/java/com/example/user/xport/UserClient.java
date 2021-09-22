package com.example.user.xport;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import com.example.user.service.UserService;
import com.example.user.service.forms.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserClient {

    private final UserService userService;

    @GetMapping
    public Collection<User> findAll()
    {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id)
    {
        return userService.findById(new UserId(id));
    }

    @PostMapping
    public ResponseEntity register(@RequestBody UserForm userForm)
    {
        UserId id;
        try
        {
            id = userService.register(userForm);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(e.getClass());
        }
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/name/{username}")
    public User findByUsername(@PathVariable String username)
    {
        return (User) userService.loadUserByUsername(username);
    }

    @GetMapping("/mail/{email}")
    public User findByEmail(@PathVariable String email)
    {
        return userService.findByEmail(email);
    }

    @PostMapping("/delete/{userId}")
    public void delete(@PathVariable String id)
    {
        if(userService.findById(new UserId(id)) != null)
            userService.deleteUser(UserId.of(id));
    }

}