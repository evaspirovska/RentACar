package com.example.user.domain.model;

import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.user.domain.valueobject.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "application_user")
@Getter
public class User extends AbstractEntity<UserId>  implements UserDetails {

    private String username;
    private String password;
    private String email;
    private String telephone;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    boolean accountNotExpired = true;
    boolean accountNonLocked = true;
    boolean credentialsNonExpired = true;
    boolean enabled = true;

    protected User() {
        super(UserId.randomId(UserId.class));
    }

    public static User create(String username, String password, String email, String telephone, Role role) {
        User u = new User();
        u.username = username;
        u.password = password;
        u.email = email;
        u.telephone = telephone;
        u.role = role;
        return u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNotExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
