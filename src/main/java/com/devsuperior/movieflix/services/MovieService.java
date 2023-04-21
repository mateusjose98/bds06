package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dtos.GenreDTO;
import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private AuthService authService;

    public Page<MovieDTO> findAll(Long genreId, Pageable pageable) {
        Page<Movie> movies = repository.findAllByGenre(genreId, pageable);
        return movies.map(movie -> new MovieDTO(movie, null));
    }

    public MovieDTO findByIdDetail(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        GenreDTO genre = new GenreDTO(movie.getGenre());
        return new MovieDTO(movie, genre);

    }

}
