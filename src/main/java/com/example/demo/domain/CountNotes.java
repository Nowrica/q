package com.example.demo.domain;

public record CountNotes(Long value) {

    public boolean isOverLimit() {
        return value > 5;
    }
}
