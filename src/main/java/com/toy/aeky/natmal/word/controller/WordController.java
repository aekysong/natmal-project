package com.toy.aeky.natmal.word.controller;

import com.toy.aeky.natmal.word.domain.WordGetResponseDto;
import com.toy.aeky.natmal.word.domain.WordSaveRequestDto;
import com.toy.aeky.natmal.word.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class WordController {

    private WordService wordService;

    @GetMapping("/words")
    public String getAllWords(Model model) {
        model.addAttribute("words", wordService.findAllDesc());
        return "word_list";
    }
}
