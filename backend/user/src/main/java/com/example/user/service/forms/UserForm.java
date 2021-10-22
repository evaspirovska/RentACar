package com.example.user.service.forms;

import com.example.user.domain.model.User;
import com.example.user.domain.valueobject.Role;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserForm {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String telephone;
    private Role role;

    public UserForm() {
    }

    public UserForm(@NotNull String username, @NotNull String password, @NotNull String email, @NotNull String telephone, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.role = role;
    }

    public static UserForm of(User user) {
        UserForm uf = new UserForm();
        uf.username = user.getUsername();
        uf.role = user.getRole();
        return uf;
    }
}
