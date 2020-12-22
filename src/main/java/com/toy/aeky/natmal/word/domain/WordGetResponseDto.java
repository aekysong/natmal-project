package com.toy.aeky.natmal.word.domain;

import lombok.Getter;

@Getter
public class WordGetResponseDto {

    private Long id;
    private String author;
    private String word;
    private String meaning;

    public WordGetResponseDto(Word entity) {
        id = entity.getId();
        author = entity.getAuthor();
        word = entity.getWord();
        meaning = entity.getMeaning();
    }
}
