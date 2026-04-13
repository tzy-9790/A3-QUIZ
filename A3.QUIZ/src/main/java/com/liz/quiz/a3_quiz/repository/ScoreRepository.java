package com.liz.quiz.a3_quiz.repository;

import com.liz.quiz.a3_quiz.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findTop10ByOrderByTotalPointsDesc();
}
