package com.toy.aeky.natmal.note.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoteGetResponseDto {

    private Long id;
    private String author;
    private String word;
    private String content;
    private LocalDateTime createdDate;

    public NoteGetResponseDto(Note entity) {
        id = entity.getId();
        author = entity.getAuthor();
        word = entity.getWord();
        content = entity.getContent();
        createdDate = entity.getCreatedDate();
    }
}
