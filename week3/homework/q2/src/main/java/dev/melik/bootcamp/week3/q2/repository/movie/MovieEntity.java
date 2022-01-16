package dev.melik.bootcamp.week3.q2.repository.movie;

import dev.melik.bootcamp.week3.q2.controller.movie.MovieGenre;
import dev.melik.bootcamp.week3.q2.repository.rate.RateEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private MovieGenre genre;

    private Integer releaseYear;

    private String director;

    @OneToMany(mappedBy = "movie",fetch = FetchType.EAGER)
    private List<RateEntity> rates = new java.util.ArrayList<>();

}
