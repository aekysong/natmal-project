package com.toy.aeky.natmal.word.controller;

import com.toy.aeky.natmal.word.domain.WordGetResponseDto;
import com.toy.aeky.natmal.word.domain.WordSaveRequestDto;
import com.toy.aeky.natmal.word.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class WordRestController {

    private WordService wordService;

    @PostMapping("/words")
    public Long saveWord(@RequestBody WordSaveRequestDto dto) {
        System.out.println("REQUEST>> " +  dto.getAuthor() + dto.getWord() + ": " + dto.getMeaning());
        return wordService.save(dto);
    }
}
