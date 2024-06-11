package com.example.demo.application.service;

public class CannotWriteNoteException extends RuntimeException {
    public CannotWriteNoteException(int counted, int limit) {
        super("Cannot write note. Current count: " + counted + ", limit: " + limit);
    }
}
