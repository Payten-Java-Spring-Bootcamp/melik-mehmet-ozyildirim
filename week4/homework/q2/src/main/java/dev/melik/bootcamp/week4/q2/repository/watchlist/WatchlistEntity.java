package dev.melik.bootcamp.week4.q2.repository.watchlist;

import dev.melik.bootcamp.week4.q2.repository.member.MemberEntity;
import dev.melik.bootcamp.week4.q2.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "watchlist")
public class WatchlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToMany
    private List<MovieEntity> movies;
}
