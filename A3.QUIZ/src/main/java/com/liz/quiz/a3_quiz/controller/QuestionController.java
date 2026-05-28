package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.QuizMatchupDTO;
import com.liz.quiz.a3_quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuestionController {

    private final QuizService quizService;

    public QuestionController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/versus")
    public ResponseEntity<List<QuizMatchupDTO>> getVersusSession(
            @RequestParam("type") String type,
            @RequestParam(value = "excludeIds", required = false) List<Long> excludeIds) {

        List<QuizMatchupDTO> matchupList = quizService.getQuizMatchup(type, excludeIds);

        if (matchupList == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(matchupList);
    }
}
