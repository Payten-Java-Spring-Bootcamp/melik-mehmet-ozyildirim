package dev.melik.bootcamp.week4.q2.repository.actor;

import dev.melik.bootcamp.week4.q2.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actor")
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthDate;

    @ManyToMany(mappedBy = "cast")
    private List<MovieEntity> movies = new java.util.ArrayList<>();
}
