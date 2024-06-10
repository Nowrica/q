package com.example.demo.application.service;

import com.example.demo.application.port.in.ReadNoteUseCase;
import com.example.demo.application.port.in.RequestNote;
import com.example.demo.application.port.in.WriteNoteUseCase;
import com.example.demo.application.port.out.NoteRepository;
import com.example.demo.application.port.out.UserRepository;
import com.example.demo.domain.CountNotes;
import com.example.demo.domain.Note;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements WriteNoteUseCase, ReadNoteUseCase {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void write(RequestNote requestNote, User.Id userId) {
        User user = userRepository.findById(userId);
        if (user.getMembership().isFreeAndExpired()) {
            throw new FreeUserCannotWriteNoteException("User is not allowed to write notes");
        }
        CountNotes countNotes = noteRepository.countNotes(userId);
        if (countNotes.isOverLimit()) {
            throw new UserHasExceededNoteLimitException("User has exceeded note limit");
        }

        noteRepository.save(requestNote.toDomain(), user);

    }

    @Override
    public List<Note> readAllNotes() {
        return noteRepository.findAll();
    }
}
