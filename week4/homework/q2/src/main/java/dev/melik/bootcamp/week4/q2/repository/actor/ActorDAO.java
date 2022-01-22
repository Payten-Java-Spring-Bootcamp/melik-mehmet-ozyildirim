package dev.melik.bootcamp.week4.q2.repository.actor;

import dev.melik.bootcamp.week4.q2.repository.movie.MovieEntity;
import dev.melik.bootcamp.week4.q2.service.movie.Movie;

import java.util.List;

public interface ActorDAO {

    ActorEntity createActor(ActorEntity actorEntity);

    List<ActorEntity> createActors(List<ActorEntity> actorEntities);

    List<ActorEntity> getActorsById(List<Long> ids);

    ActorEntity getById(Long actorId);
}
