package com.example.user.domain.model;

import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "application_user")
@Getter
public class User extends AbstractEntity<UserId> {

    private String username;
    private String password;
    private String email;
    private String telephone;

    protected User() {
        super(UserId.randomId(UserId.class));
    }

    public static User create(String username, String password, String email, String telephone) {
        User u = new User();
        u.username = username;
        u.password = password;
        u.email = email;
        u.telephone = telephone;
        return u;
    }
}
