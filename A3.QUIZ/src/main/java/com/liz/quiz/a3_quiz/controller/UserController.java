package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.EmailDTO;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.service.UserService;
import com.liz.quiz.a3_quiz.repository.UserRepository; // Importação adicionada
import org.springframework.beans.factory.annotation.Autowired; // Importação adicionada
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    
    // Injeção do repositório para conseguirmos gravar os dados
    @Autowired
    private UserRepository userRepository; 

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedUser = userService.login(user.getUsername());
            return ResponseEntity.ok(loggedUser);
        } catch (RuntimeException e) {
            // Retorna 404 para o JS saber que tem de o registar
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody User user) {
        try {
            // AQUI ESTÁ A CORREÇÃO: Agora estamos a SALVAR o utilizador na base de dados
            User newUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao gravar na base de dados: " + e.getMessage());
        }
    }

    @PostMapping("/anonymous")
    public ResponseEntity<User> enterAsAnonymous() {
        User anonymous = userService.createAnonymousUser();
        return ResponseEntity.status(HttpStatus.CREATED).body(anonymous);
    }

    @PatchMapping("/{id}/email")
    public ResponseEntity<?> addEmail(@PathVariable Long id, @RequestBody EmailDTO payload) {
        try {
            User updatedUser = userService.addEmailToUser(id, payload.getEmail());
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}