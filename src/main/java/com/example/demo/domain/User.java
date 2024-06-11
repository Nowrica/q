package com.example.demo.domain;

import lombok.Getter;

public class User {

    @Getter private Id id;


    @Getter
    private Membership membership;


    public record Id(String id) {
    }
}
