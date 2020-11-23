package com.toy.aeky.natmal.sentence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SentenceController {

    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello(Model model) {
        return "Hello World!";
    }
}
