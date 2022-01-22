package dev.melik.bootcamp.week4.q2.service.movie;

import dev.melik.bootcamp.week4.q2.controller.movie.MovieGenre;
import dev.melik.bootcamp.week4.q2.repository.movie.MovieEntity;
import dev.melik.bootcamp.week4.q2.service.actor.Actor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class Movie {

    private Long id;

    private String name;

    private MovieGenre genre;

    private Integer releaseYear;

    private String director;

    private List<Actor> cast;

    public MovieEntity toEntity() {
        MovieEntity movieEntity=new MovieEntity();
        movieEntity.setId(id);
        movieEntity.setName(name);
        movieEntity.setGenre(genre);
        movieEntity.setReleaseYear(releaseYear);
        movieEntity.setCast(cast.stream().map(Actor::toEntity).collect(Collectors.toList()));
        movieEntity.setDirector(director);
        return movieEntity;
    }
    public static Movie fromEntity(MovieEntity movieEntity){
        return Movie.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .genre(movieEntity.getGenre())
                .director(movieEntity.getDirector())
                .cast(Actor.fromEntity(movieEntity.getCast()))
                .releaseYear(movieEntity.getReleaseYear())
                .build();
    }
    public static List<Movie> fromEntity(List<MovieEntity> movieEntities){
        return movieEntities.stream()
                .map(Movie::fromEntity)
                .collect(Collectors.toList());
    }
}
