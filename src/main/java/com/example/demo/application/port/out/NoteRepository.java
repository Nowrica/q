package com.example.demo.application.port.out;

import com.example.demo.domain.CountNotes;
import com.example.demo.domain.Note;
import com.example.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    Optional<Note> getById(Long id);

    Note findById(Long id);

    List<Note> findAll();

    void save(Note note, User user);

    CountNotes countNotes(User.Id userId);

}
