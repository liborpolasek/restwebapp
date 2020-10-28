package com.polasek.restwebapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.polasek.restwebapp.sentence.Sentence;

@Controller
public class SentenceClientController {
    @Autowired
    private SentenceServiceImpl service;

    @GetMapping(value = "/s")
    public String findAll(Model model) {
        model.addAttribute("sentences", service.findAll());
        model.addAttribute("newSentence", new Sentence());
        return "sentences";
    }
    
    @PostMapping(value = "/s")
    public String create(@ModelAttribute("newSentence") Sentence s) {
        service.create(s);
        return "redirect:/s";
    }
}
