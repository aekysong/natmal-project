package com.toy.aeky.natmal.word.service;

import com.toy.aeky.natmal.word.domain.Word;
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
        if (!isDuplicate(dto)) { //중복 검사
            return wordRepository.save(dto.toEntity()).getId();
        }
        else {
            throw new IllegalStateException("[ERROR] 이미 등록된 단어임");
        }
    }

    private boolean isDuplicate(WordSaveRequestDto dto) {
        if (wordRepository.existsByWord(dto.getWord()) && wordRepository.existsByMeaning(dto.getMeaning())) {
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public List<WordGetResponseDto> findAllDesc() {
        return wordRepository.findAllDesc()
                .map(WordGetResponseDto::new) // :: method reference operator
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public WordGetResponseDto getLatestWord() {
        return new WordGetResponseDto(wordRepository.findTopByOrderByIdDesc());
    }
}
