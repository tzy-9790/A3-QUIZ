package com.liz.quiz.a3_quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // Isso vai fazer o Spring procurar o index.html na pasta que vamos ajustar
        return "index";
    }
}