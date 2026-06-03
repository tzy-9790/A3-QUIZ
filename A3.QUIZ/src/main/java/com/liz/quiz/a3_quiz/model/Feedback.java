package com.liz.quiz.a3_quiz.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "feedbacks")
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A mensagem que o utilizador vai escrever
    @Column(nullable = false, length = 500)
    private String mensagem;

    // RELACIONAMENTO: Muitas mensagens podem pertencer a Um Utilizador
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User autor;
}