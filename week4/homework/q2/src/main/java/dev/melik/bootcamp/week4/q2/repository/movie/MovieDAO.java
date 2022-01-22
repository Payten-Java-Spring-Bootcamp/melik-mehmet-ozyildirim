package dev.melik.bootcamp.week4.q2.repository.movie;

import dev.melik.bootcamp.week4.q2.repository.actor.ActorEntity;
import dev.melik.bootcamp.week4.q2.service.actor.Actor;

import java.util.List;

public interface MovieDAO {

    MovieEntity createMovie(MovieEntity movieEntity);

    MovieEntity getMovie(Long id);

    void deleteMovie(Long id);

    List<ActorEntity> getActorsOf(Long movieId);
}
