package dev.melik.bootcamp.week4.q2.controller.movie;

import dev.melik.bootcamp.week4.q2.controller.actor.ActorResponse;
import dev.melik.bootcamp.week4.q2.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreateResponse createMovie(@RequestBody @Valid MovieCreateRequest movieCreateRequest) {
        return MovieCreateResponse.fromMovie(movieService.createMovie(movieCreateRequest.toMovie()));
    }

    @GetMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponse getMovie(@PathVariable Long id) {
        return MovieResponse.fromMovie(movieService.getMovie(id));
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/movies/{id}/actors")
    public List<ActorResponse> getActorsOf(@PathVariable Long id){
        return ActorResponse.fromActor(movieService.getActorsOf(id));
    }
}
