package com.example.demo.domain;

import com.example.demo.application.port.in.RequestNote;
import com.example.demo.application.port.out.NoteRepository;
import lombok.Getter;

@Getter
public class Note {

    private Id id;

    private String title;

    private String content;

    private User writer;

    public static Note from(RequestNote requestNote, User user) {
        return new Note();
    }

    public static class Id {
        private Long id;

        public Id(Long id) {
            this.id = id;
        }

        public Long getValue() {
            return id;
        }
    }
}
