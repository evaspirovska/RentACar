package com.example.user.service.forms;

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
}
