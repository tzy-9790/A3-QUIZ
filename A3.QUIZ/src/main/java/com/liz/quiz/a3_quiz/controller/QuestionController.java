package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.QuizMatchupDTO;
import com.liz.quiz.a3_quiz.model.QuizMedia;
import com.liz.quiz.a3_quiz.repository.QuizMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private QuizMediaRepository quizMediaRepository;

    private final Random random = new Random();

    @GetMapping("/versus")
    public ResponseEntity<List<QuizMatchupDTO>> getVersusSession(
            @RequestParam("type") String type,
            @RequestParam(value = "rounds", defaultValue = "5") int rounds) {

        String formattedType = type.toUpperCase();

        List<QuizMedia> reals = quizMediaRepository.findRandomRealMedia(formattedType, rounds);
        List<QuizMedia> ais = quizMediaRepository.findRandomAiMedia(formattedType, rounds);

        if (reals.isEmpty() || ais.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        int totalRounds = Math.min(Math.min(reals.size(), ais.size()), rounds);
        List<QuizMatchupDTO> matchupList = new ArrayList<>();

        for (int i = 0; i < totalRounds; i++) {
            QuizMedia real = reals.get(i);
            QuizMedia ai = ais.get(i);

            // Joga a moeda: se for true, Real vai para a esquerda (A). Se for false, IA vai para a esquerda (A).
            boolean keepOrder = random.nextBoolean();

            if (keepOrder) {
                // Opção A é Real, Opção B é IA. Como o jogador deve clicar na IA, a resposta certa é 'B'
                matchupList.add(new QuizMatchupDTO(real, ai, "B"));
            } else {
                // Opção A é IA, Opção B é Real. Como o jogador deve clicar na IA, a resposta certa é 'A'
                matchupList.add(new QuizMatchupDTO(ai, real, "A"));
            }
        }

        return ResponseEntity.ok(matchupList);
    }
}