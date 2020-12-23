package com.toy.aeky.natmal.word.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("SELECT w " +
            "FROM Word w " +
            "ORDER BY w.id DESC")
    Stream<Word> findAllDesc();

    Word findTopByOrderByIdDesc();
    boolean existsByWord(String word);
    boolean existsByMeaning(String meaning);
}
