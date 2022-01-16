package dev.melik.bootcamp.week3.q2.repository.rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateDAOImpl implements RateDAO{

    private final RateJpaRepository rateJpaRepository;

    @Override
    public RateEntity postRate(RateEntity rateEntity) {
        return rateJpaRepository.save(rateEntity);
    }

    @Override
    public List<RateEntity> getRatesByMovieId(Long movieId) {
        return rateJpaRepository.getRatesByMovieId(movieId);
    }

}
