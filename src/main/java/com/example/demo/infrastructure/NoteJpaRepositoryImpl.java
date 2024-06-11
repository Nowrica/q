package com.example.demo.infrastructure;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteJpaRepositoryImpl implements NoteJpaRepository {
    @Override
    public List<NoteEntity> findAll() {
        return List.of();
    }

    @Override
    public NoteEntity findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Optional<NoteEntity> getById(Long id) {
        return Optional.empty();
    }
}
