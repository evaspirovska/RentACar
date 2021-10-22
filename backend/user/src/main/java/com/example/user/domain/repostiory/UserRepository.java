package com.example.user.domain.repostiory;

import com.example.user.domain.model.User;
import com.example.user.domain.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
