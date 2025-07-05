package com.example.DDDProject.infrastructure.persistence.jpa;

import com.example.DDDProject.domain.model.Movie;
import com.example.DDDProject.domain.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaMovieRepository implements MovieRepository {

    private final SpringDataMovieJpaRepo jpaRepo;

    public JpaMovieRepository(SpringDataMovieJpaRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public List<Movie> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return jpaRepo.findById(id);
    }
}
