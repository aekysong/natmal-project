package com.toy.aeky.natmal.word.service;

import com.toy.aeky.natmal.word.domain.WordRepository;
import com.toy.aeky.natmal.word.domain.WordSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class WordService {

    private WordRepository wordRepository;

    @Transactional
    public Long save(WordSaveRequestDto dto) {
        return wordRepository.save(dto.toEntity()).getId();
    }
}
