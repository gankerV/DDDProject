package com.example.DDDProject.domain.repository;

import com.example.DDDProject.domain.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<Movie> findAll();
    Optional<Movie> findById(Integer id);
}

