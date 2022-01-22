package dev.melik.bootcamp.week4.q2.controller.watchlist;

import dev.melik.bootcamp.week4.q2.service.watchlist.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WatchlistController {

    private final WatchlistService watchlistService;

    @PostMapping("/watchlists")
    public WatchlistCreateResponse createWatchlist(@RequestBody @Valid WatchlistCreateRequest watchlistCreateRequest){
        return WatchlistCreateResponse.fromWatchlist(watchlistService.createWatchlist(watchlistCreateRequest.toWatchlist()));
    }

    @GetMapping("/watchlists")
    public List<WatchlistResponse> getWatchlistsOfMember(@RequestParam Long memberId){
        return WatchlistResponse.fromWatchlist(watchlistService.getWatchlistsOfMember(memberId));
    }

}
