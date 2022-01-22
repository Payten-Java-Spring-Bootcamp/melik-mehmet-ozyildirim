package dev.melik.bootcamp.week4.q2.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {

}
