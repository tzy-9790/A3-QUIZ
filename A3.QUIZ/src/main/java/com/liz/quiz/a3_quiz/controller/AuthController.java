package com.liz.quiz.a3_quiz.controller;

import com.liz.quiz.a3_quiz.dto.LoginDTO;
import com.liz.quiz.a3_quiz.model.User;
import com.liz.quiz.a3_quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> fazerLogin(@RequestBody LoginDTO loginRequest) {
        // Procura o usuário no banco
        Optional<User> userOpt = userRepository.findByUsername(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            // O usuário JÁ EXISTE. Vamos checar a senha:
            User user = userOpt.get();
            
            // Se a senha bater, retorna OK (200)
            if (loginRequest.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok(Map.of("message", "Acesso autorizado"));
            } else {
                // Se a senha for diferente, retorna ERRO Não Autorizado (401)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                     .body(Map.of("error", "Senha incorreta"));
            }
        } else {
            // O usuário NÃO EXISTE. Como é um jogo, criamos a conta dele na hora!
            User newUser = new User();
            newUser.setUsername(loginRequest.getUsername());
            newUser.setPassword(loginRequest.getPassword()); // Salva a senha escolhida
            newUser.setAnonymous(false);
            newUser.setGlobalPoints(0);
            userRepository.save(newUser);
            
            return ResponseEntity.ok(Map.of("message", "Conta criada com sucesso"));
        }
    }
}
