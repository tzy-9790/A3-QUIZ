package com.liz.quiz.a3_quiz.dto;

import com.liz.quiz.a3_quiz.model.QuizMedia;

public class QuizMatchupDTO {
    private QuizMedia mediaA;
    private QuizMedia mediaB;
    private String correctAnswer; // Será "A" ou "B"

    public QuizMatchupDTO(QuizMedia mediaA, QuizMedia mediaB, String correctAnswer) {
        this.mediaA = mediaA;
        this.mediaB = mediaB;
        this.correctAnswer = correctAnswer;
    }

    // Getters e Setters
    public QuizMedia getMediaA() { return mediaA; }
    public void setMediaA(QuizMedia mediaA) { this.mediaA = mediaA; }

    public QuizMedia getMediaB() { return mediaB; }
    public void setMediaB(QuizMedia mediaB) { this.mediaB = mediaB; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
}