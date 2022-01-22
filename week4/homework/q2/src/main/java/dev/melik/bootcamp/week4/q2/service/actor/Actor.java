package dev.melik.bootcamp.week4.q2.service.actor;

import dev.melik.bootcamp.week4.q2.repository.actor.ActorEntity;
import dev.melik.bootcamp.week4.q2.repository.movie.MovieEntity;
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
public class Actor {

    private Long id;

    private String name;

    private Date birthDate;

    public static List<Actor> fromEntity(List<ActorEntity> actorEntities) {
        return actorEntities.stream().map(Actor::fromEntity).collect(Collectors.toList());
    }

    public static Actor fromEntity(ActorEntity actorEntity) {
        return Actor.builder()
                .id(actorEntity.getId())
                .name(actorEntity.getName())
                .birthDate(actorEntity.getBirthDate())
                .build();
    }

    public ActorEntity toEntity() {
        ActorEntity actorEntity=new ActorEntity();
        actorEntity.setId(id);
        actorEntity.setName(name);
        actorEntity.setBirthDate(birthDate);
        return actorEntity;
    }
}
