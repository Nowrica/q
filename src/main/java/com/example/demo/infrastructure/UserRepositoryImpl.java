package com.example.demo.infrastructure;

import com.example.demo.application.port.out.UserRepository;
import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findById(User.Id userId) {
        return null;
    }
}
