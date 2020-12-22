package com.toy.aeky.natmal.note.controller;

import com.toy.aeky.natmal.note.domain.NoteSaveRequestDto;
import com.toy.aeky.natmal.note.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class NoteRestController {

    private NoteService noteService;

    @PostMapping("/notes")
    public String saveNote(@RequestBody NoteSaveRequestDto dto) {
        System.out.println("REQUEST>> " + dto.getAuthor() + dto.getWord() + ": " + dto.getContent());
        noteService.save(dto);
        return "redirect:/index";
    }
}
