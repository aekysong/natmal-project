package com.toy.aeky.natmal.note.controller;

import com.toy.aeky.natmal.note.domain.NoteGetResponseDto;
import com.toy.aeky.natmal.note.domain.NoteSaveRequestDto;
import com.toy.aeky.natmal.note.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class NoteRestController {

    private NoteService noteService;

    @GetMapping("/notes")
    public ResponseEntity<List> getAllNotes() {
        return new ResponseEntity<>(noteService.findAllDesc(), HttpStatus.OK);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NoteGetResponseDto> getNote(@PathVariable("id") Long id) {
        return new ResponseEntity<>(noteService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Long> saveNote(@RequestBody NoteSaveRequestDto dto) {
        System.out.println("REQUEST>> " + dto.getAuthor() + ">> " + dto.getWord() + ": " + dto.getContent());
        if (!dto.getContent().contains(dto.getWord())) {
            System.out.println("[ERROR] 단어가 문장에 사용되지 않음");
            return new ResponseEntity<Long>(-1L, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Long>(noteService.save(dto), HttpStatus.CREATED);
    }
}
