package com.example.demo.infrastructure;

import com.example.demo.domain.Membership;
import com.example.demo.domain.User;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static UserEntity from(User writer) {
        return new UserEntity();
    }

    public User toModel() {
        return User.builder().id(new User.Id(id.toString())).username(username).password(password).role(role).membership(Membership.createFree()).build();
    }

}
