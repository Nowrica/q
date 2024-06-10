package com.example.demo.controller;

import com.example.demo.application.port.in.RequestNote;
import com.example.demo.application.port.in.WriteNoteUseCase;
import com.example.demo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    private final WriteNoteUseCase noteService;

    public NoteController(WriteNoteUseCase noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/note")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createNote(RequestNote requestNote, String userId) {

        noteService.write(requestNote, new User.Id(userId));

    }
}
