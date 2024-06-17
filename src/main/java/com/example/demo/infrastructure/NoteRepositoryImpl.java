package com.example.demo.infrastructure;

import com.example.demo.application.port.out.NoteRepository;
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
        return noteJpaRepository.findById(id).map(NoteEntity::toDomain);
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
    public Note.Id save(Note note) {
        return new Note.Id(noteJpaRepository.save(NoteEntity.from(note)).getId());
    }

    @Override
    public int count(User.Id userId) {
        return findAll().stream().filter(note -> note.getWriter().getId().equals(userId)).toList().size();
    }
}
