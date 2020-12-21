package com.toy.aeky.natmal.word.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String word;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String meaning;

    @Builder
    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
}
