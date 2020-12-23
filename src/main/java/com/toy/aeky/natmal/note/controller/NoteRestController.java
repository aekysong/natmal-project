package com.toy.aeky.natmal.note.controller;

import com.toy.aeky.natmal.note.domain.Note;
import com.toy.aeky.natmal.note.domain.NoteGetResponseDto;
import com.toy.aeky.natmal.note.domain.NoteSaveRequestDto;
import com.toy.aeky.natmal.note.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class NoteRestController {

    private NoteService noteService;

    @GetMapping("/api/notes")
    public ResponseEntity<List> getAllNotes() {
        return new ResponseEntity<>(noteService.findAllDesc(), HttpStatus.OK);
    }

    @GetMapping("/api/notes/{id}")
    public ResponseEntity<NoteGetResponseDto> getNote(@PathVariable("id") Long id) {
        return new ResponseEntity<>(noteService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/api/notes")
    public ResponseEntity<Long> saveNote(@RequestBody NoteSaveRequestDto dto) {
        System.out.println("REQUEST>> " + dto.getAuthor() + dto.getWord() + ": " + dto.getContent());
        return new ResponseEntity<Long>(noteService.save(dto), HttpStatus.OK);
    }
}
