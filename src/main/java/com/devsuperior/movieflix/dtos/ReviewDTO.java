package com.devsuperior.movieflix.dtos;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

import javax.validation.constraints.NotBlank;

public class ReviewDTO {

    private Long id;
    @NotBlank
    private String text;
    private Long movieId;
    private UserDTO user;

    public ReviewDTO() {

    }


    public ReviewDTO(Review review, User user) {
        this.movieId = review.getMovie().getId();
        this.user = new UserDTO(user);
        this.text = review.getText();
        this.id = review.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
