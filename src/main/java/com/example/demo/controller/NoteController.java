package com.example.demo.controller;

import com.example.demo.application.port.in.ReadNoteUseCase;
import com.example.demo.application.port.in.RequestNote;
import com.example.demo.application.port.in.WriteNoteUseCase;
import com.example.demo.application.port.out.ResponseNote;
import com.example.demo.domain.Note;
import com.example.demo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private final WriteNoteUseCase noteService;
    private final ReadNoteUseCase readNoteUseCase;

    public NoteController(WriteNoteUseCase noteService, ReadNoteUseCase readNoteUseCase) {
        this.noteService = noteService;
        this.readNoteUseCase = readNoteUseCase;
    }

    @PostMapping("/note")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Note.Id> createNote(RequestNote requestNote, User user) {
        return ResponseEntity.ok(noteService.write(requestNote, user));
    }

    @GetMapping("/note")
    public ResponseEntity<List<ResponseNote>> readNotes() {
        return ResponseEntity.ok(readNoteUseCase.readAllNotes().stream().map(ResponseNote::from).toList());
    }
}
