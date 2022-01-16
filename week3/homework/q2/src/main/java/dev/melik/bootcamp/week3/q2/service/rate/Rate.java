package dev.melik.bootcamp.week3.q2.service.rate;

import dev.melik.bootcamp.week3.q2.repository.member.MemberEntity;
import dev.melik.bootcamp.week3.q2.repository.rate.RateEntity;
import dev.melik.bootcamp.week3.q2.repository.movie.MovieEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Rate {

    private Long id;

    private Long memberId;

    private Integer point;

    private Long movieId;

    public static Rate fromEntity(RateEntity rateEntity) {
        return Rate.builder()
                .id(rateEntity.getId())
                .movieId(rateEntity.getMovie().getId())
                .memberId(rateEntity.getMember().getId())
                .point(rateEntity.getPoint())
                .build();
    }

    public RateEntity toEntity() {
        RateEntity rateEntity=new RateEntity();
        rateEntity.setId(id);

        MovieEntity movieEntity=new MovieEntity();
        movieEntity.setId(movieId);
        rateEntity.setMovie(movieEntity);

        MemberEntity memberEntity=new MemberEntity();
        memberEntity.setId(memberId);
        rateEntity.setMember(memberEntity);

        rateEntity.setPoint(point);
        return rateEntity;
    }
}
