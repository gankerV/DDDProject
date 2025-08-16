package com.example.DDDProject.controller;

import java.util.List;
import java.util.Map;

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

import com.example.DDDProject.application.MovieService;
import com.example.DDDProject.domain.entities.Movie;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Map<String, Object> movieData) {
        try {
            String name = (String) movieData.get("name");
            String description = (String) movieData.get("description");
            Integer duration = (Integer) movieData.get("duration");
            String poster = (String) movieData.get("poster");

            if (name == null || description == null || duration == null || poster == null) {
                return ResponseEntity.badRequest().build();
            }

            Movie movie = movieService.createMovie(name, description, duration, poster);
            return ResponseEntity.status(HttpStatus.CREATED).body(movie);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/poster/{poster}")
    public ResponseEntity<List<Movie>> getMoviesByPoster(@PathVariable String poster) {
        List<Movie> movies = movieService.findByPoster(poster);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMoviesByName(@RequestParam String name) {
        List<Movie> movies = movieService.searchMoviesByName(name);
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Map<String, Object> movieData) {
        try {
            String name = (String) movieData.get("name");
            String description = (String) movieData.get("description");
            Integer duration = (Integer) movieData.get("duration");
            String poster = (String) movieData.get("poster");

            if (name == null || description == null || duration == null || poster == null) {
                return ResponseEntity.badRequest().build();
            }

            Movie movie = movieService.updateMovie(id, name, description, duration, poster);
            return ResponseEntity.ok(movie);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
