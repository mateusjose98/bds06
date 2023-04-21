package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m LEFT JOIN m.genre g WHERE g.id = :genreId OR :genreId IS NULL ORDER BY m.title ASC")
    Page<Movie> findAllByGenre(Long genreId, Pageable pageable);
}
