package dev.melik.bootcamp.week4.q2.service.watchlist;

import dev.melik.bootcamp.week4.q2.repository.watchlist.WatchlistDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchlistServiceImpl implements WatchlistService{

    private final WatchlistDAO watchlistDAO;

    @Override
    public Watchlist createWatchlist(Watchlist watchlist) {
        return Watchlist.fromEntity(watchlistDAO.createWatchlist(watchlist.toEntity()));
    }

    @Override
    public List<Watchlist> getWatchlistsOfMember(Long memberId) {
        return Watchlist.fromEntity(watchlistDAO.getWatchlistsOfMember(memberId));
    }
}
