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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1")
public class WordRestController {

    private WordService wordService;

    @GetMapping("/words")
    public ResponseEntity<List> getAllWords() {
        return new ResponseEntity<List>(wordService.findAllDesc(), HttpStatus.OK);
    }

    @GetMapping("/word")
    public ResponseEntity<WordGetResponseDto> getLatestWord() {
        return new ResponseEntity<>(wordService.getLatestWord(), HttpStatus.OK);
    }

    @PostMapping("/words")
    public ResponseEntity<Long> saveWord(@RequestBody WordSaveRequestDto dto) {
        System.out.println("[WordRestController] REQUEST>> " +  dto.getAuthor() + ">> " + dto.getWord() + ": " + dto.getMeaning());
        try {
            return new ResponseEntity<>(wordService.save(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(-1L, HttpStatus.CONFLICT);
        }
    }
}
