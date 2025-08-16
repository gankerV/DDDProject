package com.example.DDDProject.domain.repositories;

import com.example.DDDProject.domain.entities.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Optional<Movie> findById(Long id);
    List<Movie> findAll();
    List<Movie> findByPoster(String poster);
    List<Movie> findByNameContainingIgnoreCase(String name);
    Movie save(Movie movie);
    void deleteById(Long id);
}
