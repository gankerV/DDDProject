package com.example.DDDProject.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DDDProject.domain.entities.Showtime;
import com.example.DDDProject.domain.repositories.ShowtimeRepository;

@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;

    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public List<Showtime> getShowtimesByMovieId(Long movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    public Showtime createShowtime(Integer movieId, java.time.LocalDateTime startTime, java.time.LocalDateTime endTime) {
        Showtime showtime = new Showtime(movieId, startTime, endTime);
        return showtimeRepository.save(showtime);
    }

    public Showtime getShowtimeById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public List<Showtime> getShowtimesByDateRange(java.time.LocalDateTime start, java.time.LocalDateTime end) {
        return showtimeRepository.findByStartTimeBetween(start, end);
    }

    public Showtime updateShowtimeMovieId(Long id, Integer movieId) {
        Showtime existingShowtime = showtimeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Showtime not found with id: " + id));

        existingShowtime.setMovieId(movieId);
        return showtimeRepository.save(existingShowtime);
    }

}
