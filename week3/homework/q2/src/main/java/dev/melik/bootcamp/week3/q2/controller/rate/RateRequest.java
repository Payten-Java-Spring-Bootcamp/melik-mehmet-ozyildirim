package dev.melik.bootcamp.week3.q2.controller.rate;

import dev.melik.bootcamp.week3.q2.service.member.Member;
import dev.melik.bootcamp.week3.q2.service.rate.Rate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RateRequest {

    @NotNull
    private Long memberId;

    @NotNull
    private Long movieId;

    @Min(1)
    @Max(5)
    @NotNull
    private Integer point;

    public static Rate toRate(RateRequest rateRequest) {
        return Rate.builder()
                .memberId(rateRequest.getMemberId())
                .movieId(rateRequest.getMovieId())
                .point(rateRequest.getPoint())
                .build();
    }
}
