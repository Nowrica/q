package com.example.demo.application.port.in;

import com.example.demo.domain.Note;

public class RequestNote {

    private String title;

    private String content;

    public Note toDomain() {
        return new Note();
    }
}
