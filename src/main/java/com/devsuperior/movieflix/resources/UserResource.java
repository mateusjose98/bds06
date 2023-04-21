package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private AuthService authService;
    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> findById() {
        User user = authService.authenticated();
        UserDTO dto = new UserDTO(user);
        return ResponseEntity.ok().body(dto);
    }
}
