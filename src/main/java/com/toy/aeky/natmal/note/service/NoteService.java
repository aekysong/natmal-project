package com.toy.aeky.natmal.note.service;

import com.toy.aeky.natmal.note.domain.NoteGetResponseDto;
import com.toy.aeky.natmal.note.domain.NoteRepository;
import com.toy.aeky.natmal.note.domain.NoteSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Transactional
    public Long save(NoteSaveRequestDto dto) {
        return noteRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<NoteGetResponseDto> findAllDesc() {
        return noteRepository.findAllDesc()
                .map(NoteGetResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NoteGetResponseDto getOne(Long id) {
        return new NoteGetResponseDto(noteRepository.getOne(id));
    }
}
