package com.liz.quiz.a3_quiz.service;

import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createAnonymousUser() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        String anonymousName = "Guest_" + randomNumber;

        while (userRepository.existsByUsername(anonymousName)) {
            randomNumber = random.nextInt(9000) + 1000;
            anonymousName = "Guest_" + randomNumber;
        }
        User user = new User();
        user.setUsername(anonymousName);
        user.setAnonymous(true);
        return userRepository.save(user);
    }

    public User login(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Este nome de usuário já está em uso!");
        }

        User user = new User();
        user.setUsername(username);
        user.setAnonymous(false);
        return userRepository.save(user);


    }
    public User addEmailToUser(Long userId, String email) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        user.setEmail(email);
        return userRepository.save(user);
    }
}
