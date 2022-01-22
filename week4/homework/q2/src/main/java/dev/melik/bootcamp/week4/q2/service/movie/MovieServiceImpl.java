package dev.melik.bootcamp.week4.q2.service.movie;

import dev.melik.bootcamp.week4.q2.repository.actor.ActorDAO;
import dev.melik.bootcamp.week4.q2.repository.actor.ActorEntity;
import dev.melik.bootcamp.week4.q2.repository.movie.MovieDAO;
import dev.melik.bootcamp.week4.q2.service.actor.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieDAO movieDAO;

    private final ActorDAO actorDAO;


    @Override
    @Transactional
    public Movie createMovie(Movie movie) {
        if (movie.getCast()==null)
            movie.setCast(new ArrayList<>());

        List<Long> actorIds=movie.getCast().stream()
                .map(Actor::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        List<ActorEntity> existedActors = actorDAO.getActorsById(actorIds);

        List<ActorEntity> actorsToCreate = movie.getCast().stream()
                .filter(actor -> actor.getId()==null)
                .map(Actor::toEntity)
                .collect(Collectors.toList());
        List<ActorEntity> createdActors = actorDAO.createActors(actorsToCreate);

        existedActors.addAll(createdActors);
        movie.setCast(Actor.fromEntity(existedActors));

        return Movie.fromEntity(movieDAO.createMovie(movie.toEntity()));
    }

    @Override
    public Movie getMovie(Long id) {
        return Movie.fromEntity(movieDAO.getMovie(id));
    }

    @Override
    public void deleteMovie(Long id) {
        movieDAO.deleteMovie(id);
    }

    @Override
    public List<Actor> getActorsOf(Long movieId) {
        return Actor.fromEntity(movieDAO.getActorsOf(movieId));
    }
}
