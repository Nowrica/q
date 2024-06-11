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

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note.Id write(RequestNote requestNote, User user) {
        CountNotes countNotes = noteRepository.countNotes(user.getId());
        if (!validate(user, countNotes)) {
            throw new CannotWriteNoteException();
        }
        return noteRepository.save(Note.from(requestNote, user), user);
    }

    private boolean validate(User user, CountNotes countNotes) {
        if (!(user.getMembership().isFree() && countNotes.isOverLimitBy(5))) {
            return false;
        }
        return user.getMembership().isBasic() && countNotes.isOverLimitBy(100);
    }

    @Override
    public List<Note> readAllNotes() {
        return noteRepository.findAll();
    }
}
