package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteJpaRepository extends JpaRepository<NoteEntity, Long> {

}
