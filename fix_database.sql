-- SQL script to fix the database schema issues
-- Run this script if Hibernate automatic schema update still fails

-- Drop existing tables (in correct order due to foreign key constraints)
DROP TABLE IF EXISTS showtimes;
DROP TABLE IF EXISTS movies;

-- Create movies table with correct structure
CREATE TABLE movies (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    duration INT,
    poster VARCHAR(500),
    PRIMARY KEY (id)
);

-- Create showtimes table with correct structure
CREATE TABLE showtimes (
    id INT NOT NULL AUTO_INCREMENT,
    movie_id INT NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE
);

-- Add indexes for better performance
CREATE INDEX idx_showtimes_movie_id ON showtimes(movie_id);
CREATE INDEX idx_showtimes_start_time ON showtimes(start_time);
CREATE INDEX idx_showtimes_end_time ON showtimes(end_time);
