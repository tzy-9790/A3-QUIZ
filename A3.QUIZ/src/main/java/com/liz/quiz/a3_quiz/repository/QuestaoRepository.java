package com.liz.quiz.a3_quiz.repository;

import com.liz.quiz.a3_quiz.model.QuizMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<QuizMedia, Long> {

    @Query(value = "SELECT * FROM questoes WHERE modo = :modo ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    QuizMedia findRandomQuestaoByModo(@Param("modo") String modo);
}
