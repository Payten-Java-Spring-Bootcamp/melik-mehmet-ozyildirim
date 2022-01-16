package dev.melik.bootcamp.week3.q2.controller.watchlist;

import dev.melik.bootcamp.week3.q2.service.movie.Movie;
import dev.melik.bootcamp.week3.q2.service.watchlist.Watchlist;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class WatchlistResponse {

    private Long id;

    private Long memberId;

    private String name;

    private List<Long> movies;

    public static List<WatchlistResponse> fromWatchlist(List<Watchlist> watchlist) {
        return watchlist.stream()
                .map(WatchlistResponse::fromWatchlist)
                .collect(Collectors.toList());
    }
    public static WatchlistResponse fromWatchlist(Watchlist watchlist) {
        return WatchlistResponse.builder()
                .id(watchlist.getId())
                .name(watchlist.getName())
                .memberId(watchlist.getMemberId())
                .movies(watchlist.getMovies())
                .build();
    }
}
