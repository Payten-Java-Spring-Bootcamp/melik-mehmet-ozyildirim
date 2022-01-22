package dev.melik.bootcamp.controller;

import dev.melik.bootcamp.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
public class MovieController {

    private final Random random = new Random();

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody @Valid Movie movie) {
        return Movie
                .builder()
                .id(random.nextLong(1000L))
                .name(movie.getName())
                .genre(movie.getGenre())
                .director(movie.getDirector())
                .cast(movie.getCast())
                .releaseYear(movie.getReleaseYear())
                .point(random.nextDouble(5D))
                .build();
    }

    @GetMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovie(@PathVariable Long id) {
        return Movie
                .builder()
                .id(id)
                .name("Fast and Famous 99")
                .releaseYear(random.nextInt(2000, 2023))
                .director("Tuentin Qarantino")
                .genre(Movie.Genre.HORROR)
                .cast(List.of("Glen David", "Hognny Swift", "Jackson Brandon", "Haley Park", "Melody Locke"))
                .build();
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long id) {
        //TODO: Remove Movie here
    }

}
