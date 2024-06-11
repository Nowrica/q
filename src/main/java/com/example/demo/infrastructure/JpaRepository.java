package com.example.demo.infrastructure;

import com.example.demo.domain.Note;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T, R> {

    R save(T entity);

    List<T> findAll();

    T findById(R id);

    void deleteById(R id);

    void deleteAll();

    boolean existsById(R id);

    Optional<T> getById(R id);
}
