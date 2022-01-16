package dev.melik.bootcamp.week3.q2.controller.rate;

import dev.melik.bootcamp.week3.q2.service.rate.Rate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class RateResponse {

    private Long id;

    private Long memberId;

    private Integer point;

    private Long movieId;

    public static List<RateResponse> fromRate(List<Rate> rates) {
        return rates.stream()
                .map(RateResponse::fromRate)
                .collect(Collectors.toList());
    }

    public static RateResponse fromRate(Rate rate) {
        return RateResponse.builder()
                .id(rate.getId())
                .memberId(rate.getMemberId())
                .movieId(rate.getMovieId())
                .point(rate.getPoint())
                .build();
    }
}
