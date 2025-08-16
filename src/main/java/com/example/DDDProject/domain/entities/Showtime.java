package com.example.DDDProject.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
    private Integer id;
    
    @Column(name = "movie_id", nullable = false, columnDefinition = "INT NOT NULL")
    private Integer movieId;
    
    @Column(name = "start_time", nullable = false, columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime startTime;
    
    @Column(name = "end_time", nullable = false, columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime endTime;

    public Showtime() {}

    public Showtime(Integer id, Integer movieId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Showtime(Integer movieId, LocalDateTime startTime, LocalDateTime endTime) {
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return Objects.equals(id, showtime.id) && Objects.equals(movieId, showtime.movieId) && Objects.equals(startTime, showtime.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, startTime);
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
