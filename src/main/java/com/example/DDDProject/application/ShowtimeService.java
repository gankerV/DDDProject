package com.example.DDDProject.application.service;

import com.example.DDDProject.domain.model.Showtime;
import com.example.DDDProject.domain.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepo;

    public ShowtimeService(ShowtimeRepository showtimeRepo) {
        this.showtimeRepo = showtimeRepo;
    }

    public List<Showtime> getShowtimesByMovieId(Integer movieId) {
        return showtimeRepo.findByMovieId(movieId);
    }
}
