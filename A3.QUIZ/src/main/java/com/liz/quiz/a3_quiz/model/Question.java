package com.liz.quiz.a3_quiz.model;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Statement;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String video1;
    private String video2;

    private Integer correctOption;

    @Column(length = 500)
    private String explanation;

}
