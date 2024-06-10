package com.example.demo.domain;

import lombok.Getter;

public class User {

    private Id id;


    @Getter
    private Membership membership;


    public record Id(String id) {
    }
}
