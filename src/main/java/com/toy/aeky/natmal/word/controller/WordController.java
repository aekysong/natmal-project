package com.toy.aeky.natmal.word.controller;

import com.toy.aeky.natmal.word.domain.WordSaveRequestDto;
import com.toy.aeky.natmal.word.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WordController {
    
    private WordService wordService;

    @PostMapping("/words")
    public String saveWord(@RequestBody WordSaveRequestDto dto) {
        System.out.println("REQUEST>> " + dto.getWord() + ": " + dto.getMeaning());
        wordService.save(dto);
        return "redirect:/index";
    }
}
