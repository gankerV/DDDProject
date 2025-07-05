package com.example.DDDProject.infrastructure.persistence.jpa;

import com.example.DDDProject.domain.model.Showtime;
import com.example.DDDProject.domain.repository.ShowtimeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaShowtimeRepository implements ShowtimeRepository {

    private final SpringDataShowtimeJpaRepo jpaRepo;

    public JpaShowtimeRepository(SpringDataShowtimeJpaRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public List<Showtime> findByMovieId(Integer movieId) {
        return jpaRepo.findByMovieId(movieId);
    }
}
