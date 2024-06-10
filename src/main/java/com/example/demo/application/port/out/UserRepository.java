package com.example.demo.application.port.out;

import com.example.demo.domain.User;

public interface UserRepository {

    User findById(User.Id userId);

}
