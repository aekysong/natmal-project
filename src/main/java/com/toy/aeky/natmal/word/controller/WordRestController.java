package com.toy.aeky.natmal.word.controller;

import com.toy.aeky.natmal.word.domain.Word;
import com.toy.aeky.natmal.word.domain.WordGetResponseDto;
import com.toy.aeky.natmal.word.domain.WordSaveRequestDto;
import com.toy.aeky.natmal.word.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class WordRestController {

    private WordService wordService;

    @GetMapping("/api/words")
    public ResponseEntity<List> getAllWords() {
        return new ResponseEntity<List>(wordService.findAllDesc(), HttpStatus.OK);
    }

    @GetMapping("/api/word")
    public ResponseEntity<WordGetResponseDto> getLatestWord() {
        return new ResponseEntity<>(wordService.getLatestWord(), HttpStatus.OK);
    }

    @PostMapping("/api/words")
    public ResponseEntity<Long> saveWord(@RequestBody WordSaveRequestDto dto) {
        System.out.println("[WordRestController] REQUEST>> " +  dto.getAuthor() + ">> " + dto.getWord() + ": " + dto.getMeaning());
        return new ResponseEntity<Long>(wordService.save(dto), HttpStatus.OK);
    }
}
