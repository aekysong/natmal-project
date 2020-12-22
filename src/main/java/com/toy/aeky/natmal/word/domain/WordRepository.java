package com.toy.aeky.natmal.word.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface WordRepository extends JpaRepository<Word, Long> {
}
