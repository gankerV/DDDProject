package com.example.DDDProject.infrastructure.repositories.jpa;

import com.example.DDDProject.domain.entities.Movie;
import com.example.DDDProject.domain.repositories.MovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMovieRepository extends JpaRepository<Movie, Long>, MovieRepository {
    @Override
    List<Movie> findByPoster(String poster);

    @Override
    List<Movie> findAll();

    @Override
    List<Movie> findByNameContainingIgnoreCase(String name);
}
