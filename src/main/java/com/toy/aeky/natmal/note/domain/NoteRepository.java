package com.toy.aeky.natmal.note.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n " +
            "FROM Note n " +
            "ORDER BY n.id DESC")
    Stream<Note> findAllDesc();
}
