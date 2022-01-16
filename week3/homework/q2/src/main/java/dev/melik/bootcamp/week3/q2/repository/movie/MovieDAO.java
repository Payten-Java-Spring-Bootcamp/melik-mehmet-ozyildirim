package dev.melik.bootcamp.week3.q2.repository.movie;

public interface MovieDAO {

    MovieEntity createMovie(MovieEntity movieEntity);

    MovieEntity getMovie(Long id);

    void deleteMovie(Long id);
}
