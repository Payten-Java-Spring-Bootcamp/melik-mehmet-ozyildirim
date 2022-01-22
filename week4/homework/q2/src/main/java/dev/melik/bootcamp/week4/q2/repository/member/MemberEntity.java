package dev.melik.bootcamp.week4.q2.repository.member;

import dev.melik.bootcamp.week4.q2.repository.rate.RateEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<RateEntity> rates;

}