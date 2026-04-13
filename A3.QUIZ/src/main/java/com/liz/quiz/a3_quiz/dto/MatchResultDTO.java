package com.liz.quiz.a3_quiz.dto;

import lombok.Data;

@Data
public class MatchResultDTO {
    private Long userId;
    private int correctAnswers;
    private double totalTimeSeconds;
}
