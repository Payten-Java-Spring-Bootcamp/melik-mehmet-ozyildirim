package dev.melik.bootcamp.week3.q2.service.rate;


import java.util.List;

public interface RateService {
    Rate postRate(Rate rate);

    List<Rate> getRatesByMovieId(Long movieId);
}
