package com.example.demo.domain;

public enum Type {
    FREE, BASIC, PREMIUM;

    public int getLimit() {
        return switch (this) {
            case FREE -> 5;
            case BASIC -> 100;
            case PREMIUM -> Integer.MAX_VALUE;
        };
    }
}
