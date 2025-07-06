DROP DATABASE IF EXISTS `dddproject`;
CREATE DATABASE `dddproject`;
USE `dddproject`;


CREATE TABLE `users` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL
);


-- Tạo bảng movies
CREATE TABLE movies (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` TEXT NOT NULL,
    `duration` INT NOT NULL,
    `poster` CHAR(200)
);

-- Tạo bảng showtimes
CREATE TABLE showtimes (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `movie_id` INT NOT NULL,
    `start_time` TIME NOT NULL,
    `end_time` TIME NOT NULL,
    FOREIGN KEY (`movie_id`) REFERENCES movies(`id`)
);

-- Chèn dữ liệu phim
INSERT INTO movies (`name`, `description`, `duration`, `poster`) VALUES
('Godzilla x Kong: The New Empire', 'The battle between two legendary monsters continues with spectacular action sequences.', 120, 'https://m.media-amazon.com/images/I/61dZ9mCP6lL._AC_UF894,1000_QL80_.jpg'),
('Dune: Part Two', 'Paul Atreides allies with the Fremen to take revenge on those who destroyed his family.', 150, 'https://m.media-amazon.com/images/M/MV5BNTc0YmQxMjEtODI5MC00NjFiLTlkMWUtOGQ5NjFmYWUyZGJhXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg'),
('Kung Fu Panda 4', 'Po returns with a new journey, facing the most dangerous enemy yet.', 95, 'https://upload.wikimedia.org/wikipedia/vi/7/7f/Kung_Fu_Panda_4_poster.jpg'),
('Inside Out 2', 'The emotions inside Riley''s mind continue their colorful and meaningful adventure.', 100, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLxnnmqHwRgHPU6G_5ThxLs28PJvgqGQaSzw&s'),
('Deadpool & Wolverine', 'Deadpool and Wolverine team up for a crazy, hilarious, and blood-soaked mission.', 110, 'https://upload.wikimedia.org/wikipedia/vi/4/4c/Deadpool_%26_Wolverine_poster.jpg');

-- Godzilla x Kong (ID 1) – Duration: 120 mins
INSERT INTO showtimes (movie_id, start_time, end_time) VALUES
(1, '09:00:00', '11:00:00'),
(1, '12:00:00', '14:00:00'),
(1, '15:00:00', '17:00:00'),
(1, '18:30:00', '20:30:00');

-- Dune: Part Two (ID 2) – Duration: 150 mins
INSERT INTO showtimes (movie_id, start_time, end_time) VALUES
(2, '10:00:00', '12:30:00'),
(2, '13:30:00', '16:00:00'),
(2, '17:00:00', '19:30:00'),
(2, '20:30:00', '23:00:00');

-- Kung Fu Panda 4 (ID 3) – Duration: 95 mins
INSERT INTO showtimes (movie_id, start_time, end_time) VALUES
(3, '08:00:00', '09:35:00'),
(3, '10:00:00', '11:35:00'),
(3, '13:00:00', '14:35:00');

-- Inside Out 2 (ID 4) – Duration: 100 mins
INSERT INTO showtimes (movie_id, start_time, end_time) VALUES
(4, '09:30:00', '11:10:00'),
(4, '11:45:00', '13:25:00'),
(4, '14:00:00', '15:40:00'),
(4, '16:15:00', '17:55:00'),
(4, '18:30:00', '20:10:00');

-- Deadpool & Wolverine (ID 5) – Duration: 110 mins
INSERT INTO showtimes (movie_id, start_time, end_time) VALUES
(5, '11:00:00', '12:50:00'),
(5, '14:00:00', '15:50:00'),
(5, '17:00:00', '18:50:00'),
(5, '20:00:00', '21:50:00'),
(5, '22:30:00', '00:20:00');