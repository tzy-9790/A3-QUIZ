package com.liz.quiz.a3_quiz.repository;

import com.liz.quiz.a3_quiz.model.QuizMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface QuizMediaRepository extends JpaRepository<QuizMedia, Long> {

    // Procura vídeos ou imagens REAIS (is_ai_generated = false) de forma aleatória
    @Query(value = "SELECT * FROM quiz_media WHERE media_type = :mediaType AND is_ai_generated = false ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<QuizMedia> findRandomRealMedia(@Param("mediaType") String mediaType, @Param("limit") int limit);

    // Procura vídeos ou imagens de IA (is_ai_generated = true) de forma aleatória
    @Query(value = "SELECT * FROM quiz_media WHERE media_type = :mediaType AND is_ai_generated = true ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<QuizMedia> findRandomAiMedia(@Param("mediaType") String mediaType, @Param("limit") int limit);
}