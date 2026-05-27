package com.liz.quiz.a3_quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizViewController {

    // Quando acessar http://localhost:8080/
    @GetMapping("/")
    public String home() {
        return "index"; // Aponta para templates/index.html
    }

    // Quando acessar http://localhost:8080/modos
    @GetMapping("/modos")
    public String escolherModo() {
        return "modos"; // Aponta para templates/modos.html
    }

    // Quando acessar http://localhost:8080/jogar
    @GetMapping("/jogar")
    public String rodarJogo() {
        return "jogo"; // Aponta para templates/jogo.html
    }
}