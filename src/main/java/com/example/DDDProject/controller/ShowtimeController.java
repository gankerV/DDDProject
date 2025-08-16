package com.example.DDDProject.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DDDProject.application.ShowtimeService;
import com.example.DDDProject.domain.entities.Showtime;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
        List<Showtime> showtimes = showtimeService.getAllShowtimes();
        return ResponseEntity.ok(showtimes);
    }

    @PostMapping
    public ResponseEntity<Showtime> createShowtime(@RequestBody Map<String, Object> showtimeData) {
        try {
            Integer movieId = Integer.valueOf(showtimeData.get("movieId").toString());
            LocalDateTime startTime = LocalDateTime.parse((String) showtimeData.get("startTime"));
            LocalDateTime endTime = LocalDateTime.parse((String) showtimeData.get("endTime"));

            if (movieId == null || startTime == null || endTime == null) {
                return ResponseEntity.badRequest().build();
            }

            Showtime showtime = showtimeService.createShowtime(movieId, startTime, endTime);
            return ResponseEntity.status(HttpStatus.CREATED).body(showtime);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Long id) {
        Showtime showtime = showtimeService.getShowtimeById(id);
        if (showtime == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(showtime);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Showtime>> getShowtimesByMovie(@PathVariable Long movieId) {
        List<Showtime> showtimes = showtimeService.getShowtimesByMovieId(movieId);
        return ResponseEntity.ok(showtimes);
    }


    @PutMapping("/{id}/movie")
    public ResponseEntity<Showtime> updateShowtimeMovieId(@PathVariable Long id, @RequestBody Map<String, Object> showtimeData) {
        try {
            Integer movieId = Integer.valueOf(showtimeData.get("movieId").toString());

            if (movieId == null) {
                return ResponseEntity.badRequest().build();
            }

            Showtime showtime = showtimeService.updateShowtimeMovieId(id, movieId);
            return ResponseEntity.ok(showtime);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
