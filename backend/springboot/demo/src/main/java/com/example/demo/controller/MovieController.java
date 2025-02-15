package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indica que esta clase maneja endpoints REST
@RequestMapping("/") // Todas las rutas empezarán con /
public class MovieController {

    private final MovieRepository movieRepository;

    // Spring inyecta automáticamente el repositorio
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Endpoint GET /
    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("{\"Api con node de peliculas\": \"Spring Boot\"}");
    }

    // Endpoint GET /movies
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    // Endpoint GET /movies/{id}
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Endpoint POST /movies
    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie newMovie = movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }
}
