package dev.melik.bootcamp.week3.q2.controller.movie;

import dev.melik.bootcamp.week3.q2.service.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieResponse {
    private Long id;

    private String name;

    private MovieGenre genre;

    private Integer releaseYear;

    private String director;

    public static MovieResponse fromMovie(Movie movie){
        return MovieResponse.builder()
                .id(movie.getId())
                .name(movie.getName())
                .director(movie.getDirector())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .build();
    }
}
