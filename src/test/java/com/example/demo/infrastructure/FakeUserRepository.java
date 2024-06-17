package com.example.demo.infrastructure;

import com.example.demo.application.port.out.UserRepository;
import com.example.demo.domain.User;

import java.util.Optional;

public class FakeUserRepository implements UserRepository {
    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.of(new User(new User.Id("1"), username, "password", User.Role.USER));
    }
}
