package dev.melik.bootcamp.week4.q2.controller.watchlist;

import dev.melik.bootcamp.week4.q2.service.watchlist.Watchlist;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class WatchlistCreateResponse {

    private Long id;

    private Long memberId;

    private String name;

    private List<Long> movies;

    public static WatchlistCreateResponse fromWatchlist(Watchlist watchlist) {
        return WatchlistCreateResponse.builder()
                .id(watchlist.getId())
                .name(watchlist.getName())
                .memberId(watchlist.getMemberId())
                .movies(watchlist.getMovies())
                .build();
    }
}
