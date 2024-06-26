package com.example.demo.application.port.out;

import com.example.demo.domain.Note;
import com.example.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    Optional<Note> getById(Long id);

    Note findById(Long id);

    List<Note> findAll();

    Note.Id save(Note note);

    int count(User.Id userId);

}
