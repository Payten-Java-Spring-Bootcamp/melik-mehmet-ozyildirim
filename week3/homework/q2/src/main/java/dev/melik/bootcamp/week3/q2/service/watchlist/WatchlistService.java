package dev.melik.bootcamp.week3.q2.service.watchlist;

import java.util.List;

public interface WatchlistService {
    Watchlist createWatchlist(Watchlist watchlist);

    List<Watchlist> getWatchlistsOfMember(Long memberId);
}
