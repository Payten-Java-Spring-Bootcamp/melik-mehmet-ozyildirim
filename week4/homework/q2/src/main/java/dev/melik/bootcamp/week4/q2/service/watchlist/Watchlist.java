package dev.melik.bootcamp.week4.q2.service.watchlist;

import dev.melik.bootcamp.week4.q2.repository.member.MemberEntity;
import dev.melik.bootcamp.week4.q2.repository.watchlist.WatchlistEntity;
import dev.melik.bootcamp.week4.q2.repository.movie.MovieEntity;
import dev.melik.bootcamp.week4.q2.service.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class Watchlist {

    private Long id;

    private Long memberId;

    private String name;

    private List<Long> movies;

    public static List<Watchlist> fromEntity(List<WatchlistEntity> watchlists) {
        return watchlists.stream()
                .map(Watchlist::fromEntity)
                .collect(Collectors.toList());
    }

    public static Watchlist fromEntity(WatchlistEntity watchlist) {
        return Watchlist.builder()
                .id(watchlist.getId())
                .name(watchlist.getName())
                .memberId(watchlist.getMember().getId())
                .movies(watchlist.getMovies().stream().map(MovieEntity::getId).collect(Collectors.toList()))
                .build();
    }

    public WatchlistEntity toEntity() {
        WatchlistEntity watchlistEntity=new WatchlistEntity();
        watchlistEntity.setId(id);

        MemberEntity memberEntity=new MemberEntity();
        memberEntity.setId(memberId);
        watchlistEntity.setMember(memberEntity);
        watchlistEntity.setName(name);

        List<MovieEntity> movieEntities =  movies.stream()
                .map(i -> Movie.builder().id(i).build().toEntity())
                .collect(Collectors.toList());

        watchlistEntity.setMovies(movieEntities);
        return watchlistEntity;
    }
}
