package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            // Pega o nome do usuario que foi reconhecido pelo spring security ( no caso ,o email)
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
            // Caso capture qualquer erro( n reconhecer usuario ou algo do tipo) vou enviar um erro de Autorizacao
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }

    }

}
