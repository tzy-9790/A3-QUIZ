package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.model.QuizMedia;
import com.liz.quiz.a3_quiz.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizViewController {

    @Autowired
    private QuestaoRepository questaoRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/modos")
    public String modos() {
        return "modos";
    }

    @GetMapping("/jogo/imagem")
    public String jogoImagem(Model model) {
        QuizMedia questao = questaoRepository.findRandomQuestaoByModo("image");
        model.addAttribute("questao", questao);
        model.addAttribute("modo", "image");
        return "jogo";
    }

    @GetMapping("/jogo/video")
    public String jogoVideo(Model model) {
        QuizMedia questao = questaoRepository.findRandomQuestaoByModo("video");
        model.addAttribute("questao", questao);
        model.addAttribute("modo", "video");
        return "jogo";
    }

    @GetMapping("/jogo/audio")
    public String jogoAudio(Model model) {
        QuizMedia questao = questaoRepository.findRandomQuestaoByModo("audio");
        model.addAttribute("questao", questao);
        model.addAttribute("modo", "audio");
        return "jogo";
    }

    @GetMapping("/score")
    public String scoreFinal() {
        return "FinalScore";
    }
}
