package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.EmailDTO;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//o front se comunica com o sistema. API RESTful. usando @RestController... definindo as rotas (endpoints) que recebem e respondem dados no fromato JSON
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    // Injeção de dependência pelo construtor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Rota para login com nome (Valida se o nome já existe)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedUser = userService.login(user.getUsername());
            return ResponseEntity.ok(loggedUser);
        } catch (RuntimeException e) {
            // Retorna erro 409 (Conflito) para o frontend mostrar a mensagem vermelha
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // Rota para entrada anónima (Gera um Guest_XXXX)
    @PostMapping("/anonymous")
    public ResponseEntity<User> enterAsAnonymous() {
        User anonymous = userService.createAnonymousUser();
        return ResponseEntity.status(HttpStatus.CREATED).body(anonymous);
    }

    // Rota para adicionar o e-mail no final do jogo
    @PatchMapping("/{id}/email")
    public ResponseEntity<?> addEmail(@PathVariable Long id, @RequestBody EmailDTO payload) {
        try {
            User updatedUser = userService.addEmailToUser(id, payload.getEmail());
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erro ao guardar e-mail: " + e.getMessage());
        }
    }
}