package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dtos.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreResource {

    @Autowired
    private GenreService service;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> findAll() {
        List<GenreDTO> result = service.findAllGenres();
        return ResponseEntity.ok(result);
    }

}
