package dev.melik.bootcamp.week4.q2.repository.watchlist;

import java.util.List;

public interface WatchlistDAO {
    WatchlistEntity createWatchlist(WatchlistEntity watchlistEntity);

    List<WatchlistEntity> getWatchlistsOfMember(Long memberId);
}
