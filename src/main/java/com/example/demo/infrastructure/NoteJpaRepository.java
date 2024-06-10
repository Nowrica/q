package com.example.demo.infrastructure;


import org.springframework.stereotype.Repository;

@Repository
public interface NoteJpaRepository extends JpaRepository<NoteEntity, Long> {
}
