package dev.melik.bootcamp.week4.q2.service.rate;

import dev.melik.bootcamp.week4.q2.repository.rate.RateDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService{

    private final RateDAO rateDAO;

    @Override
    public Rate postRate(Rate rate) {
        return Rate.fromEntity(rateDAO.postRate(rate.toEntity()));
    }

    @Override
    public List<Rate> getRatesByMovieId(Long movieId) {
        return rateDAO.getRatesByMovieId(movieId).stream()
                .map(Rate::fromEntity)
                .collect(Collectors.toList());
    }
}
