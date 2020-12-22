package com.toy.aeky.natmal.note.domain;

import com.toy.aeky.natmal.word.domain.Word;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteSaveRequestDto {

    private String author;
    private String word;
    private String content;

    @Builder
    public NoteSaveRequestDto(String author, String word, String content) {
        this.author = author;
        this.word = word;
        this.content = content;
    }

    public Note toEntity() {
        return Note.builder()
                .author(author)
                .word(word)
                .content(content)
                .build();
    }
}
