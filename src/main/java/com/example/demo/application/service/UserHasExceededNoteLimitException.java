package com.example.demo.application.service;

public class UserHasExceededNoteLimitException extends RuntimeException {
    public UserHasExceededNoteLimitException(String s) {
        super(s);
    }
}
