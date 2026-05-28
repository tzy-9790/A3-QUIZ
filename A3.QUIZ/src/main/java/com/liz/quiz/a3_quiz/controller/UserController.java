package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.EmailDTO;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedUser = userService.login(user.getUsername());
            return ResponseEntity.ok(loggedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
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
            return ResponseEntity.badRequest().body("Erro ao guardar e-mail: " + e.getMessage());
        }
    }
}
