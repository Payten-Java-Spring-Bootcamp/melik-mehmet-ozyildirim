package dev.melik.bootcamp.week4.q2.repository.watchlist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchlistDAOImpl implements WatchlistDAO{

    private final WatchlistJpaRepository watchlistJpaRepository;

    @Override
    public WatchlistEntity createWatchlist(WatchlistEntity watchlistEntity) {
        return watchlistJpaRepository.save(watchlistEntity);
    }

    @Override
    public List<WatchlistEntity> getWatchlistsOfMember(Long memberId) {
        return watchlistJpaRepository.getWatchlistsOfMember(memberId);
    }
}
