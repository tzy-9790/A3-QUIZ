package com.liz.quiz.a3_quiz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data

public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user-id", nullable = false)
    private User user;

    private int correctAnswers;
    private double totalTimeSeconds;
    private LocalDateTime playedAt = LocalDateTime.now();
    private int totalPoints;
}
