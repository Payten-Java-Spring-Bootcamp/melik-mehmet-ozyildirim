package dev.melik.bootcamp.week3.q2.service.movie;

import dev.melik.bootcamp.week3.q2.controller.movie.MovieGenre;
import dev.melik.bootcamp.week3.q2.repository.movie.MovieEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Movie {

    private Long id;

    private String name;

    private MovieGenre genre;

    private Integer releaseYear;

    private String director;

    public MovieEntity toEntity() {
        MovieEntity movieEntity=new MovieEntity();
        movieEntity.setId(id);
        movieEntity.setName(name);
        movieEntity.setGenre(genre);
        movieEntity.setReleaseYear(releaseYear);
        movieEntity.setDirector(director);
        return movieEntity;
    }
    public static Movie fromEntity(MovieEntity movieEntity){
        return Movie.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .genre(movieEntity.getGenre())
                .director(movieEntity.getDirector())
                .releaseYear(movieEntity.getReleaseYear())
                .build();
    }
}
