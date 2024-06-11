package com.example.demo.infrastructure;

public interface NoteJpaRepository extends JpaRepository<NoteEntity, Long> {
    @Override
    default Long save(NoteEntity entity) {
        return 0L;
    }
}
