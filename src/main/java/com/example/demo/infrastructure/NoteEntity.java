package com.example.demo.infrastructure;

import com.example.demo.domain.Note;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "notes")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    private UserEntity user;

    public NoteEntity() {
    }

    public NoteEntity(Long id, String title, String content, UserEntity user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }


    public Note toDomain() {
        return Note.builder().id(new Note.Id(this.id)).title(this.title).content(this.content).writer(this.user.toModel()).build();
    }

    public static NoteEntity from(Note note) {
        return new NoteEntity(Long.valueOf(note.getId().toString()), note.getTitle(), note.getContent(), UserEntity.from(note.getWriter()));
    }

}

