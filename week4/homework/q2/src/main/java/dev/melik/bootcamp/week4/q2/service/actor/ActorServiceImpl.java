package dev.melik.bootcamp.week4.q2.service.actor;

import dev.melik.bootcamp.week4.q2.repository.actor.ActorDAO;
import dev.melik.bootcamp.week4.q2.repository.movie.MovieDAO;
import dev.melik.bootcamp.week4.q2.service.movie.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService{

    private final ActorDAO actorDAO;

    @Override
    public Actor createActor(Actor actor) {
        return Actor.fromEntity(actorDAO.createActor(actor.toEntity()));
    }

    @Override
    public List<Movie> getMoviesOf(Long actorId) {
        return Movie.fromEntity(actorDAO.getById(actorId).getMovies());
    }

}
