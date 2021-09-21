package com.example.user.domain.model;

import com.example.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "application_user")
public class User extends AbstractEntity<UserId> {

    private String username;
    private String password;
    private String email;
    private String telephone;
}
