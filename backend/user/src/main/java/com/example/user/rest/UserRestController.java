package com.example.user.rest;

import com.example.sharedkernel.infra.DomainEventPublisher;
import com.example.user.domain.model.User;
import com.example.user.domain.valueobject.Role;
import com.example.user.service.UserService;
import com.example.user.service.forms.UserForm;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;
    private final RestTemplate template;
    private final DomainEventPublisher eventPublisher;

    public UserRestController(UserService userService, DomainEventPublisher eventPublisher) {
        this.userService = userService;
        this.template = new RestTemplate();
        this.template.setRequestFactory(new SimpleClientHttpRequestFactory());
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody Map<String, String> jsonPayload) {

        String username = jsonPayload.get("username");
        String password = jsonPayload.get("password");
        String email = jsonPayload.get("email");
        String telephone = jsonPayload.get("telephone");
        Role role = Role.ROLE_ADMIN;
        if (!username.contains("admin"))
            role = Role.ROLE_USER;
        UserForm userForm = new UserForm(username, password, email, telephone, role);
        String message = "";
        try {
            userService.createUser(userForm);
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest()
                    .body("try again!");
        }
        return ResponseEntity.ok().body("successful registration!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody Map<String, String> jsonPayload) {

        String username = jsonPayload.get("username");
        String password = jsonPayload.get("password");
        try {
            User user = userService.login(username, password);
            return ResponseEntity.ok(user);
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("unsuccessful login!");
        }
    }
}
