package com.toy.aeky.natmal.word.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WordSaveRequestDto {

    private String word;
    private String meaning;

    @Builder
    public WordSaveRequestDto(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public Word toEntity() {
        return Word.builder()
                .word(word)
                .meaning(meaning)
                .build();
    }
}
