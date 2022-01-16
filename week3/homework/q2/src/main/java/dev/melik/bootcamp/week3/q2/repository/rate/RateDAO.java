package dev.melik.bootcamp.week3.q2.repository.rate;

import java.util.List;

public interface RateDAO {
    RateEntity postRate(RateEntity rateEntity);

    List<RateEntity> getRatesByMovieId(Long movieId);
}
