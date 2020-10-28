package com.polasek.restwebapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.polasek.restwebapp.word.Word;

@Controller
public class WordClientController {
    @Autowired
    private WordServiceImpl service;

    @GetMapping(value = "/")
    public String findAll(Model model) {
        model.addAttribute("words", service.findAll());
        model.addAttribute("newWord", new Word());
        return "words";
    }
    
    @PostMapping(value = "/")
    public String create(@RequestParam String word, @ModelAttribute("newWord") Word w) {
        service.create(word, w);
        return "redirect:/";
    }
}
