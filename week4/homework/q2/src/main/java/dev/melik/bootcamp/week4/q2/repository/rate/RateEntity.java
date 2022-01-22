package dev.melik.bootcamp.week4.q2.repository.rate;

import dev.melik.bootcamp.week4.q2.repository.member.MemberEntity;
import dev.melik.bootcamp.week4.q2.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "rate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity member;

    @Column(nullable = false)
    private Integer point;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;
}
