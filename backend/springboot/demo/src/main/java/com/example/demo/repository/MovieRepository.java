package com.example.demo.repository;

import com.example.demo.model.Movie;
import jakarta.annotation.PostConstruct; // Para Spring Boot 3+
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {
    private List<Movie> movies = new ArrayList<>();
    private int nextId = 1;

    @PostConstruct
    public void init() {
        movies.add(new Movie(1, "El Gran Lebowski", "Joel Coen", 1998, "Comedia", 117));
        movies.add(new Movie(2, "La La Land", "Damien Chazelle", 2016, "Musical", 128));
        movies.add(new Movie(3, "Los Infiltrados", "Martin Scorsese", 2006, "Thriller", 151));
        movies.add(new Movie(4, "Ciudad de Dios", "Fernando Meirelles", 2002, "Crimen", 130));
        movies.add(new Movie(5, "Amélie", "Jean-Pierre Jeunet", 2001, "Comedia", 122));
        movies.add(new Movie(6, "Braveheart", "Mel Gibson", 1995, "Drama", 178));
        movies.add(new Movie(7, "La Lista de Schindler", "Steven Spielberg", 1993, "Drama", 195));
        movies.add(new Movie(8, "Gladiator", "Ridley Scott", 2000, "Acción", 155));
        movies.add(new Movie(9, "El Rey León", "Roger Allers", 1994, "Animación", 88));
        movies.add(new Movie(10, "El Pianista", "Roman Polanski", 2002, "Drama", 150));
        movies.add(new Movie(11, "American History X", "Tony Kaye", 1998, "Drama", 119));
        movies.add(new Movie(12, "Seven", "David Fincher", 1995, "Thriller", 127));
        movies.add(new Movie(13, "El Lobo de Wall Street", "Martin Scorsese", 2013, "Comedia", 180));
        movies.add(new Movie(14, "Slumdog Millionaire", "Danny Boyle", 2008, "Drama", 120));
        movies.add(new Movie(15, "12 Hombres Sin Piedad", "Sidney Lumet", 1957, "Drama", 96));
        movies.add(new Movie(16, "Memento", "Christopher Nolan", 2000, "Thriller", 113));
        movies.add(new Movie(17, "Eterno Resplandor de una Mente Sin Recuerdos", "Michel Gondry", 2004, "Romance", 108));
        movies.add(new Movie(18, "La Vida Es Bella", "Roberto Benigni", 1997, "Comedia", 116));
        movies.add(new Movie(19, "Casablanca", "Michael Curtiz", 1942, "Romance", 102));
        movies.add(new Movie(20, "Bastardos Sin Gloria", "Quentin Tarantino", 2009, "Guerra",153));

                nextId = movies.size() + 1;
    }

    // Método para obtener todas las películas
    public List<Movie> findAll() {
        return movies;
    }

    // Método para encontrar una película por su ID
    public Optional<Movie> findById(int id) {
        return movies.stream().filter(m -> m.getId() == id).findFirst();
    }

    // Método para guardar una nueva película
    public Movie save(Movie movie) {
        movie.setId(nextId++);
        movies.add(movie);
        return movie;
    }
}
