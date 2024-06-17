package com.example.demo.application.port.out;

import com.example.demo.domain.Note;
import com.example.demo.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseNote {

    private Long id;

    private String title;

    private String content;

    private User writer;

    public static ResponseNote from(Note note) {
        return new ResponseNote(note.getId().getValue(), note.getTitle(), note.getContent(), note.getWriter());
    }
}
