package com.example.demo.domain;

public record CountNotes(Long value) {

    public boolean isOverLimitBy(int count) {
        return count <= value;
    }
}
