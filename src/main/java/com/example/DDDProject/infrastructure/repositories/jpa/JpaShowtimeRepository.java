package com.example.DDDProject.infrastructure.repositories.jpa;

import com.example.DDDProject.domain.entities.Showtime;
import com.example.DDDProject.domain.repositories.ShowtimeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaShowtimeRepository extends JpaRepository<Showtime, Long>, ShowtimeRepository {
    @Override
    List<Showtime> findByMovieId(Long movieId);

    @Override
    List<Showtime> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
