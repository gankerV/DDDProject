package com.example.DDDProject.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DDDProject.domain.entities.Movie;
import com.example.DDDProject.domain.repositories.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(String name, String description, Integer duration, String poster) {
        Movie movie = new Movie(name, description, duration, poster);
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> searchMoviesByName(String name) {
        return movieRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Movie> findByPoster(String poster) {
        return movieRepository.findByPoster(poster);
    }

    public Movie updateMovie(Long id, String name, String description, Integer duration, String poster) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + id));

        existingMovie.setName(name);
        existingMovie.setDescription(description);
        existingMovie.setDuration(duration);
        existingMovie.setPoster(poster);

        return movieRepository.save(existingMovie);
    }
}
