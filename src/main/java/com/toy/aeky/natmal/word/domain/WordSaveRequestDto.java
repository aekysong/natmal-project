package com.toy.aeky.natmal.word.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WordSaveRequestDto {

    private String author;
    private String word;
    private String meaning;

    @Builder
    public WordSaveRequestDto(String author, String word, String meaning) {
        this.author = author;
        this.word = word;
        this.meaning = meaning;
    }

    public Word toEntity() {
        return Word.builder()
                .author(author)
                .word(word)
                .meaning(meaning)
                .build();
    }
}
