package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {

    @Autowired
    private ReviewRepository repository;
    @Autowired AuthService authService;

    @Autowired
    MovieRepository movieRepository;
    public ReviewDTO create(ReviewDTO reviewDTO) {
        Review toSave = toEntity(reviewDTO);
        return new ReviewDTO(repository.save(toSave), toSave.getUser());

    }

    private Review toEntity(ReviewDTO reviewDTO) {
        User user = authService.authenticated();
        Review result = new Review();
        BeanUtils.copyProperties(reviewDTO, result, "user", "movieId");
        result.setMovie(movieRepository.getOne(reviewDTO.getMovieId()));
        result.setUser(user);
        return result;
    }
}
