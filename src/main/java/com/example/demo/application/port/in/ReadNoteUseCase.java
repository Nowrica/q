package com.example.demo.application.port.in;

import com.example.demo.domain.Note;

import java.util.List;

public interface ReadNoteUseCase {

    List<Note> readAllNotes();
}
