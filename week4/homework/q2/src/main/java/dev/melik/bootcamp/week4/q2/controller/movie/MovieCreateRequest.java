package dev.melik.bootcamp.week4.q2.controller.movie;

import dev.melik.bootcamp.week4.q2.controller.actor.ActorRequest;
import dev.melik.bootcamp.week4.q2.service.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MovieCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private MovieGenre genre;

    @NotNull
    private Integer releaseYear;

    @NotBlank
    private String director;

    @Valid
    private List<ActorRequest> cast;

    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .releaseYear(releaseYear)
                .director(director)
                .genre(genre)
                .cast(cast.stream().map(ActorRequest::toActor).collect(Collectors.toList()))
                .build();
    }

}
