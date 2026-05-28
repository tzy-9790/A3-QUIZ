package com.liz.quiz.a3_quiz.service;

import com.liz.quiz.a3_quiz.model.Score;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.repository.ScoreRepository;
import com.liz.quiz.a3_quiz.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;

    public ScoreService(ScoreRepository scoreRepository, UserRepository userRepository) {
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }
    public Score saveMatchResult(Long userId, int correctAnswers, double totalTimeSeconds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        int matchPoints = (int) ((correctAnswers * 1000) - (totalTimeSeconds * 10));
        matchPoints = Math.max(0, matchPoints);

        Score match = new Score();
        match.setUser(user);
        match.setCorrectAnswers(correctAnswers);
        match.setTotalTimeSeconds(totalTimeSeconds);
        match.setTotalPoints(matchPoints);
        scoreRepository.save(match);

        user.setGlobalPoints(user.getGlobalPoints() + matchPoints);
        userRepository.save(user);

        return match;

    }

    public List<User> getGlobalRanking() {
        return userRepository.findTop10ByOrderByGlobalPointsDesc();
    }
}
