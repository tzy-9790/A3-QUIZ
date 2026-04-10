package com.liz.quiz.a3_quiz.service;

import com.liz.quiz.a3_quiz.model.Question;
import com.liz.quiz.a3_quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {
    private final QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);

    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }
}
