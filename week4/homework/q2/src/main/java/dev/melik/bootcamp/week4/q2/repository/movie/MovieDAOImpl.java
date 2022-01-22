package dev.melik.bootcamp.week4.q2.repository.movie;

import dev.melik.bootcamp.week4.q2.repository.actor.ActorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieDAOImpl implements MovieDAO{

    private final MovieJpaRepository movieJpaRepository;

    @Override
    public MovieEntity createMovie(MovieEntity movieEntity) {
        return movieJpaRepository.save(movieEntity);
    }

    @Override
    public MovieEntity getMovie(Long id) {
        Optional<MovieEntity> optionalMovieEntity = movieJpaRepository.findById(id);
        if (optionalMovieEntity.isPresent()){
            return optionalMovieEntity.get();
        }else {
            throw new RuntimeException("The movie with id: "+id+" not found.");
        }
    }

    @Override
    public void deleteMovie(Long id) {
        movieJpaRepository.deleteById(id);
    }

    @Override
    public List<ActorEntity> getActorsOf(Long movieId) {
        MovieEntity movieEntity=getMovie(movieId);
        return movieEntity.getCast();
    }

}
