package com.liz.quiz.a3_quiz.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private boolean isAnonymous;

    private int globalPoints = 0;
    private String email;
}
