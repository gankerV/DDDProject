package com.example.DDDProject.domain.repositories;

import com.example.DDDProject.domain.entities.Showtime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShowtimeRepository {
    Optional<Showtime> findById(Long id);
    List<Showtime> findAll();
    List<Showtime> findByMovieId(Long movieId);
    List<Showtime> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    Showtime save(Showtime showtime);
    void deleteById(Long id);
}
