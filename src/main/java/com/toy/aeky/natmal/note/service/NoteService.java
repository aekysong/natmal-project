package com.toy.aeky.natmal.note.service;

import com.toy.aeky.natmal.note.domain.NoteRepository;
import com.toy.aeky.natmal.note.domain.NoteSaveRequestDto;
import com.toy.aeky.natmal.word.domain.WordSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Transactional
    public Long save(NoteSaveRequestDto dto) {
        return noteRepository.save(dto.toEntity()).getId();
    }
}
