package com.toy.aeky.natmal.word.service;

import com.toy.aeky.natmal.word.domain.WordGetResponseDto;
import com.toy.aeky.natmal.word.domain.WordRepository;
import com.toy.aeky.natmal.word.domain.WordSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class WordService {

    private WordRepository wordRepository;

    @Transactional
    public Long save(WordSaveRequestDto dto) {
        return wordRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<WordGetResponseDto> findAllDesc() {
        return wordRepository.findAllDesc()
                .map(word -> new WordGetResponseDto(word))
                .collect(Collectors.toList());
    }
}
