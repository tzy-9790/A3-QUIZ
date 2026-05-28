package com.liz.quiz.a3_quiz.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "questoes")
@Data
public class QuizMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modo;
    private String instrucao;

    @Column(name = "midia_esquerda")
    private String midiaEsquerda;

    @Column(name = "midia_direita")
    private String midiaDireita;

    @Column(name = "lado_ia")
    private String ladoIa;

    @Column(name = "mensagem_correto")
    private String mensagemCorreto;

    @Column(name = "mensagem_errado")
    private String mensagemErrado;
}