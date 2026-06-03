package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.MatchResultDTO;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/match")
    public ResponseEntity<?> saveMatch(@RequestBody MatchResultDTO result) {
        String nomeJogador = result.getUserId();
        int pontosGanhos = result.getCorrectAnswers();

        if (nomeJogador == null || nomeJogador.isEmpty()) {
            nomeJogador = "Visitante";
        }

        Optional<User> userOpt = userRepository.findByUsername(nomeJogador);

        if (userOpt.isPresent()) {
            User u = userOpt.get();
            u.setGlobalPoints(u.getGlobalPoints() + pontosGanhos);
            userRepository.save(u);
        } else {
            User novo = new User();
            novo.setUsername(nomeJogador);
            novo.setGlobalPoints(pontosGanhos);
            novo.setAnonymous(true);
            userRepository.save(novo);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/ranking/global")
    public ResponseEntity<List<User>> getGlobalRanking() {
        return ResponseEntity.ok(userRepository.findTop10ByOrderByGlobalPointsDesc());
    }
}
