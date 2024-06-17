package com.example.demo.infrastructure;

import com.example.demo.application.port.out.UserRepository;
import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.of(userJpaRepository.findByUsername(username).map(UserEntity::toModel).orElseThrow());
    }
}
