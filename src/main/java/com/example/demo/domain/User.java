package com.example.demo.domain;

import com.example.demo.infrastructure.Role;
import lombok.Builder;
import lombok.Getter;


public class User {

    @Getter private final Id id;

    @Getter
    private final String username;

    @Getter
    private final String password;

    @Getter
    private final Role role;

    @Getter
    private final Membership membership;

    @Builder
    public User(Id id, String username, String password, Role role, Membership membership) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.membership = membership;
    }

    public Role getRole() {
        return role;
    }


    public record Id(String id) {
    }
}
