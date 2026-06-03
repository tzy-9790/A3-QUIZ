package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.FeedbackDTO;
import com.liz.quiz.a3_quiz.model.Feedback;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.repository.FeedbackRepository;
import com.liz.quiz.a3_quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin(origins = "*")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    // Rota para CRIAR uma nova mensagem no mural
    @PostMapping
    public ResponseEntity<?> adicionarFeedback(@RequestBody FeedbackDTO dto) {
        Optional<User> userOpt = userRepository.findByUsername(dto.getUsername());

        if (userOpt.isPresent()) {
            Feedback f = new Feedback();
            f.setMensagem(dto.getMensagem());
            f.setAutor(userOpt.get()); // Liga a mensagem ao utilizador real!
            
            feedbackRepository.save(f);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Agente não encontrado no sistema.");
        }
    }

    // Rota para LER todas as mensagens
    @GetMapping
    public ResponseEntity<List<Feedback>> listarFeedbacks() {
        return ResponseEntity.ok(feedbackRepository.findAllByOrderByIdDesc());
    }
}