package com.example.demo.infrastructure;

import com.example.demo.domain.Note;
import com.example.demo.domain.User;
import lombok.Getter;

@Getter
public class NoteEntity {
    private Long id;
    private String title;
    private String content;
    private UserEntity user;

    public NoteEntity(Long id, String title, String content, UserEntity user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public NoteEntity(Note note, User user) {
        this.id = note.getId().getValue();
        this.title = note.getTitle();
        this.content = note.getContent();
        this.user = new UserEntity(user);
    }

    public Note toDomain() {
        return new Note();
    }
}

