package com.example.demo.application.service;

public class FreeUserCannotWriteNoteException extends RuntimeException {
    public FreeUserCannotWriteNoteException(String s) {
        super(s);
    }
}
