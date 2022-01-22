package dev.melik.bootcamp.week4.q2.service.actor;

import dev.melik.bootcamp.week4.q2.service.movie.Movie;

import java.util.List;

public interface ActorService {

    Actor createActor(Actor actor);

    List<Movie> getMoviesOf(Long actorId);
}
