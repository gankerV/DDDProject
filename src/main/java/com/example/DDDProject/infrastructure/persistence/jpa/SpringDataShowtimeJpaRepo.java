package com.example.DDDProject.infrastructure.persistence.jpa;

import com.example.DDDProject.domain.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataShowtimeJpaRepo extends JpaRepository<Showtime, Integer> {
    List<Showtime> findByMovieId(Integer movieId);
}
