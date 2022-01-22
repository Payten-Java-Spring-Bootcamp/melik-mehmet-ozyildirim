package dev.melik.bootcamp.week4.q2.repository.rate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateJpaRepository extends JpaRepository<RateEntity, Long> {

    //@Query(value = "FROM RateEntity WHERE RateEntity.movie.id = :movieId")
    List<RateEntity> getRatesByMovieId(Long movieId);
}
