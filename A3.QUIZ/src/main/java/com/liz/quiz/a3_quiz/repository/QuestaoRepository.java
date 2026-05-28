package com.liz.quiz.a3_quiz.QuestaoRepository;

import com.liz.quiz.a3_quiz.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    // Comando nativo do Postgres para sortear uma questão aleatória baseada no modo de jogo
    @Query(value = "SELECT * FROM questoes WHERE modo = :modo ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Questao findRandomQuestaoByModo(@Param("modo") String modo);
}