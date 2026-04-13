package com.liz.quiz.a3_quiz.repository;

import com.liz.quiz.a3_quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

    List<User> findTop10ByOrderByGlobalPointsDesc();
}