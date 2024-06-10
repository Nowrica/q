package com.example.demo.domain;

import com.example.demo.infrastructure.NoteEntity;
import lombok.Getter;

@Getter
public class Note {

    private Id id;

    private String title;

    private String content;

    public static Note from(NoteEntity noteEntity) {
        return new Note();
    }

    public static class Id {
        private Long id;

        public Long getValue() {
            return id;
        }
    }
}
