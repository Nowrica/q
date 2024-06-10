package com.example.demo.infrastructure;

import com.example.demo.application.port.out.NoteRepository;
import com.example.demo.domain.CountNotes;
import com.example.demo.domain.Note;
import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepositoryImpl implements NoteRepository {


    private final NoteJpaRepository noteJpaRepository;

    public NoteRepositoryImpl(NoteJpaRepository noteJpaRepository) {
        this.noteJpaRepository = noteJpaRepository;
    }


    @Override
    public Optional<Note> getById(Long id) {
        return noteJpaRepository.getById(id).map(NoteEntity::toDomain);
    }

    @Override
    public Note findById(Long id) {
        return getById(id).orElseThrow(() -> new IllegalArgumentException("Note not found"));
    }

    @Override
    public List<Note> findAll() {
        return noteJpaRepository.findAll().stream().map(NoteEntity::toDomain).toList();
    }

    @Override
    public void save(Note note, User user) {
        noteJpaRepository.save(new NoteEntity(note, user));
    }

    @Override
    public CountNotes countNotes(User.Id userId) {
        return null;
    }
}
