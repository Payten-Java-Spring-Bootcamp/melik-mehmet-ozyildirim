package dev.melik.bootcamp.week4.q2.controller.movie;

import dev.melik.bootcamp.week4.q2.controller.actor.ActorResponse;
import dev.melik.bootcamp.week4.q2.service.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MovieCreateResponse {

    private Long id;

    private String name;

    private MovieGenre genre;

    private Integer releaseYear;

    private String director;

    private List<ActorResponse> cast;

    public static MovieCreateResponse fromMovie(Movie movie){
        return MovieCreateResponse.builder()
                .id(movie.getId())
                .name(movie.getName())
                .director(movie.getDirector())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .cast(ActorResponse.fromActor(movie.getCast()))
                .build();
    }

}
