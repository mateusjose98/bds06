package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.services.ReviewService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("reviews")
public class ReviewResource {

    @Autowired
    private ReviewService service;
    @PostMapping
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity<ReviewDTO> create(@RequestBody @Valid ReviewDTO reviewDTO) {
        ReviewDTO result = service.create(reviewDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
