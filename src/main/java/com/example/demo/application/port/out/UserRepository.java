package com.example.demo.application.port.out;

import com.example.demo.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);
}
