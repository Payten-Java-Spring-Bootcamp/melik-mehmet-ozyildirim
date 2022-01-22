package dev.melik.bootcamp.week4.q2.controller.actor;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.melik.bootcamp.week4.q2.service.actor.Actor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ActorResponse {

    private Long id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date birthDate;

    public static List<ActorResponse> fromActor(List<Actor> cast) {
        return cast.stream()
                .map(ActorResponse::fromActor)
                .collect(Collectors.toList());
    }

    public static ActorResponse fromActor(Actor actor) {
        return ActorResponse.builder()
                .id(actor.getId())
                .name(actor.getName())
                .birthDate(actor.getBirthDate())
                .build();
    }
}
