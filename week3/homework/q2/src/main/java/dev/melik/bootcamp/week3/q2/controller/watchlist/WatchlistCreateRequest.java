package dev.melik.bootcamp.week3.q2.controller.watchlist;

import dev.melik.bootcamp.week3.q2.service.watchlist.Watchlist;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class WatchlistCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Long memberId;

    @NotEmpty
    private List<Long> movies;

    public Watchlist toWatchlist() {
        return Watchlist.builder()
                .name(name)
                .memberId(memberId)
                .movies(movies)
                .build();
    }
}
