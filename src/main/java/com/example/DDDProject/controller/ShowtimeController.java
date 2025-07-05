package com.example.DDDProject.interfaces.web;

import com.example.DDDProject.domain.model.Showtime;
import com.example.DDDProject.application.service.ShowtimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping("/movie/{movieId}")
    public List<Showtime> getByMovieId(@PathVariable Integer movieId) {
        return showtimeService.getShowtimesByMovieId(movieId);
    }
}
