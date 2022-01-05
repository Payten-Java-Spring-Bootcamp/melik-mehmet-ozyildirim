package dev.melik.bootcamp.controller;

import dev.melik.bootcamp.model.Member;
import dev.melik.bootcamp.model.Movie;
import dev.melik.bootcamp.model.WatchList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class MemberController {

    private final Random random = new Random();

    @PostMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie rateMovie(@PathVariable Long id, @RequestBody Long memberId, @RequestBody Double point) {
        return Movie
                .builder()
                .id(id)
                .name("Fast and Famous 99")
                .releaseYear(random.nextInt(2000, 2023))
                .director("Tuentin Qarantino")
                .genre(Movie.Genre.HORROR)
                .cast(List.of("Glen David", "Hognny Swift", "Jackson Brandon", "Haley Park", "Melody Locke"))
                .point(5 + point / 2d)//Generate new point
                .build();
    }

    @PostMapping("/watchlist")
    @ResponseStatus(HttpStatus.CREATED)
    public List<WatchList> createWatchList(@RequestBody Long memberId, @RequestBody String watchlistName) {
        Member member = Member
                .builder()
                .id(memberId)
                .name("Dummy Member")
                .build();
        List<WatchList> watchLists = new ArrayList<>(); //Member's watchlist from the database.
        watchLists.add(WatchList.builder().member(member).id(random.nextLong(100)).name("Old Watchlist").build());
        watchLists.add(WatchList.builder().member(member).id(random.nextLong(100)).name(watchlistName).build());
        return watchLists;
    }

    @PutMapping("/watchlist/{watchListId}")
    @ResponseStatus(HttpStatus.OK)
    public WatchList addMovieToWatchList(@PathVariable Long watchListId, @RequestBody Long movieId) {
        Movie movie1 = Movie.builder().id(random.nextLong(100)).name("Dummy Movie 1").build();
        Movie movie2 = Movie.builder().id(random.nextLong(100)).name("Dummy Movie 2").build();
        Movie movie3 = Movie.builder().id(movieId).name("Newly added movie").build();
        return WatchList.builder().movies(List.of(movie1, movie2, movie3)).build();
    }

}
