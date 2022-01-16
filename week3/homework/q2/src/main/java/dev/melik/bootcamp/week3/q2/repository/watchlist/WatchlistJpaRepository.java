package dev.melik.bootcamp.week3.q2.repository.watchlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WatchlistJpaRepository extends JpaRepository<WatchlistEntity, Long> {

    @Query(value = "SELECT w FROM WatchlistEntity as w WHERE w.member.id = :memberId")
    List<WatchlistEntity> getWatchlistsOfMember(Long memberId);
}
