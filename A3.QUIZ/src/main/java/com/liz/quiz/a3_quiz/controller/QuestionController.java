package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.model.Question;
import com.liz.quiz.a3_quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    private final QuizService quizService;

    public QuestionController(QuizService quizService){
        this.quizService = quizService;
    }
    @GetMapping
    public List<Question> getAll() {
        return quizService.getAllQuestion();
    }

    @PostMapping
    public Question create(@RequestBody Question question){
        return quizService.saveQuestion(question);
    }

}
