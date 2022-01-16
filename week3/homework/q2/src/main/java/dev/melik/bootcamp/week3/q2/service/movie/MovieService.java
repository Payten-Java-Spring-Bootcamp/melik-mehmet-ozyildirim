package dev.melik.bootcamp.week3.q2.service.movie;

import dev.melik.bootcamp.week3.q2.service.movie.Movie;

public interface MovieService {
    Movie createMovie(Movie movie);

    Movie getMovie(Long id);

    void deleteMovie(Long id);
}
