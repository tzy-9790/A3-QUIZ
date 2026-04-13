package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.MatchResultDTO;
import com.liz.quiz.a3_quiz.model.Score;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.repository.UserRepository;
import com.liz.quiz.a3_quiz.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    private final ScoreService scoreService;
    private final UserRepository userRepository;

    public ScoreController(ScoreService scoreService, UserRepository userRepository) {
        this.scoreService = scoreService;
        this.userRepository = userRepository;
    }

    @PostMapping("/match")
    public ResponseEntity<Score> saveMatch(@RequestBody MatchResultDTO result) {
        Score savedScore = scoreService.saveMatchResult(
                result.getUserId(),
                result.getCorrectAnswers(),
                result.getTotalTimeSeconds()
        );
        return ResponseEntity.ok(savedScore);
    }

    @GetMapping("/ranking/global")
    public ResponseEntity<List<User>> getGlobalRanking() {
        List<User> top10 = userRepository.findTop10ByOrderByGlobalPointsDesc();
        return ResponseEntity.ok(top10);
    }
}
