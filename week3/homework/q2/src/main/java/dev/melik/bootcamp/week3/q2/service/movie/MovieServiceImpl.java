package dev.melik.bootcamp.week3.q2.service.movie;

import dev.melik.bootcamp.week3.q2.repository.movie.MovieDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieDAO movieDAO;


    @Override
    public Movie createMovie(Movie movie) {
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
}
