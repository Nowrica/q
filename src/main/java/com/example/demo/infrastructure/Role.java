package com.example.demo.infrastructure;

public enum Role {
    USER("USER"), ADMIN("ADMIN");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}