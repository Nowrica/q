package com.example.demo.infrastructure;

import com.example.demo.domain.User;

public class UserEntity {

    public static UserEntity from(User writer) {
        return new UserEntity();
    }

    public User toModel() {
        return new User();
    }
}
