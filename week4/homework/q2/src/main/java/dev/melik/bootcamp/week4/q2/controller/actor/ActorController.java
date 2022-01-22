package dev.melik.bootcamp.week4.q2.controller.actor;

import dev.melik.bootcamp.week4.q2.controller.movie.MovieResponse;
import dev.melik.bootcamp.week4.q2.service.actor.Actor;
import dev.melik.bootcamp.week4.q2.service.actor.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @PostMapping("/actors")
    public ActorResponse createActor(@RequestBody @Valid ActorRequest actorRequest){
        return ActorResponse.fromActor(actorService.createActor(actorRequest.toActor()));
    }

    @GetMapping("/actors/{actorId}/movies")
    public List<MovieResponse> getMoviesOf(@PathVariable Long actorId){
        return MovieResponse.fromMovie(actorService.getMoviesOf(actorId));
    }
}
