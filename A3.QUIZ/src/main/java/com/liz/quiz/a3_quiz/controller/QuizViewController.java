package com.liz.quiz.a3_quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizViewController {

    // Esta rota carrega a página inicial
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // ADICIONE ESTE MÉTODO ABAIXO PARA FUNCIONAR:
    @GetMapping("/modos")
    public String modos() {
        return "modos"; // Isso procura pelo arquivo modos.html na pasta templates
    }

    @GetMapping("/jogo")
    public String jogo() {
        return "jogo";
    }

    @GetMapping("/jogosAudio")
    public String jogosAudio() {
        return "JogosAudio";
    }

    @GetMapping("/jogosVideo")
    public String jogosVideo() {
        return "JogosVideo";
    }

    @GetMapping("/score")
    public String score() {
        return "FinalScore"; 
    }
    @GetMapping("/mural")
    public String mural() {
        return "mural";
    }
}