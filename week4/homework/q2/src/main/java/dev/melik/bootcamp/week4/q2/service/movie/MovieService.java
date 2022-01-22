package dev.melik.bootcamp.week4.q2.service.movie;

import dev.melik.bootcamp.week4.q2.service.actor.Actor;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);

    Movie getMovie(Long id);

    void deleteMovie(Long id);

    List<Actor> getActorsOf(Long movieId);
}
