package dev.melik.bootcamp.week3.q2.controller.movie;

import dev.melik.bootcamp.week3.q2.service.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .releaseYear(releaseYear)
                .director(director)
                .genre(genre)
                .build();
    }

}
