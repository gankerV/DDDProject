package com.example.DDDProject.domain.repository;


import com.example.DDDProject.domain.model.Showtime;
import java.util.List;

public interface ShowtimeRepository {
    List<Showtime> findByMovieId(Integer movieId);
}
