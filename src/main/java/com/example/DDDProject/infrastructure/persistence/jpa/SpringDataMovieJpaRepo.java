package com.example.DDDProject.infrastructure.persistence.jpa;

import com.example.DDDProject.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMovieJpaRepo extends JpaRepository<Movie, Integer> {}
