package com.liz.quiz.a3_quiz.service;

import com.liz.quiz.a3_quiz.dto.QuizMatchupDTO;
import com.liz.quiz.a3_quiz.model.QuizMedia;
import com.liz.quiz.a3_quiz.repository.QuizMediaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    private final QuizMediaRepository quizMediaRepository;
    private final Random random = new Random();

    public QuizService(QuizMediaRepository quizMediaRepository) {
        this.quizMediaRepository = quizMediaRepository;
    }

    public List<QuizMatchupDTO> getQuizMatchup(String type, List<Long> excludeIds) {
        String formattedType = type.toUpperCase();

        if (excludeIds == null || excludeIds.isEmpty()) {
            excludeIds = new ArrayList<>();
            excludeIds.add(-1L);
        }

        List<QuizMedia> reals = quizMediaRepository.findRandomRealMediaExcluding(formattedType, excludeIds, 1);
        List<QuizMedia> ais = quizMediaRepository.findRandomAiMediaExcluding(formattedType, excludeIds, 1);

        if (reals.isEmpty() || ais.isEmpty()) {
            return null; // Sinaliza que o quiz acabou
        }

        List<QuizMatchupDTO> matchupList = new ArrayList<>();
        QuizMedia real = reals.get(0);
        QuizMedia ai = ais.get(0);

        boolean keepOrder = random.nextBoolean();

        if (keepOrder) {
            matchupList.add(new QuizMatchupDTO(real, ai, "B"));
        } else {
            matchupList.add(new QuizMatchupDTO(ai, real, "A"));
        }

        return matchupList;
    }
}
