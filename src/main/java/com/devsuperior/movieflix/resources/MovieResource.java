package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAllPaged(@RequestParam(required = false) Long genreId, Pageable pageable) {
        Page<MovieDTO> result = service.findAll(genreId, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        MovieDTO result = service.findByIdDetail(id);
        return ResponseEntity.ok(result);
    }
}
