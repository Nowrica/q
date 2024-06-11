package com.example.demo.application.service;

import com.example.demo.application.port.in.ReadNoteUseCase;
import com.example.demo.application.port.in.RequestNote;
import com.example.demo.application.port.in.WriteNoteUseCase;
import com.example.demo.application.port.out.NoteRepository;
import com.example.demo.domain.Note;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements WriteNoteUseCase, ReadNoteUseCase {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note.Id write(RequestNote requestNote, User user) {
        checkNoteLimitBy(user);
        return noteRepository.save(Note.from(requestNote, user));
    }

    private void checkNoteLimitBy(User user) {
        int limit = user.getMembership().getLimit();
        int counted = noteRepository.count(user.getId());
        if (counted > limit) {
            throw new CannotWriteNoteException(counted, limit);
        }
    }

    @Override
    public List<Note> readAllNotes() {
        return noteRepository.findAll();
    }
}