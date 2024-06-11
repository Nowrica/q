package com.example.demo.domain;

import com.example.demo.application.port.in.RequestNote;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Note {

    private Id id;

    private String title;

    private String content;

    private User writer;

    public static Note from(RequestNote requestNote, User user) {
        return new Note(new Id(0L), requestNote.getTitle(), requestNote.getContent(), user);
    }

    public static class Id {
        private final Long id;

        public Id(Long id) {
            this.id = id;
        }

        public Long getValue() {
            return id;
        }
    }
}
