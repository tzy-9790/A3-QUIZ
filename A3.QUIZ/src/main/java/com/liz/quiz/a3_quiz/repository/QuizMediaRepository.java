package com.liz.quiz.a3_quiz.repository;

import com.liz.quiz.a3_quiz.model.QuizMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizMediaRepository extends JpaRepository<QuizMedia, Long> {

    @Query(value = "SELECT * FROM quiz_media WHERE media_type = :type AND is_ai_generated = false AND id NOT IN (:excludeIds) ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<QuizMedia> findRandomRealMediaExcluding(@Param("type") String type, @Param("excludeIds") List<Long> excludeIds, @Param("limit") int limit);

    @Query(value = "SELECT * FROM quiz_media WHERE media_type = :type AND is_ai_generated = true AND id NOT IN (:excludeIds) ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<QuizMedia> findRandomAiMediaExcluding(@Param("type") String type, @Param("excludeIds") List<Long> excludeIds, @Param("limit") int limit);
}