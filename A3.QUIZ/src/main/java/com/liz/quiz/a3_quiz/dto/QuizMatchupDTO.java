package com.liz.quiz.a3_quiz.dto;

import com.liz.quiz.a3_quiz.model.QuizMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizMatchupDTO {
    private QuizMedia mediaA;
    private QuizMedia mediaB;
    private String correctAnswer; // Será "A" ou "B"
}
