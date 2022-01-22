package dev.melik.bootcamp.week4.q2.controller.actor;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.melik.bootcamp.week4.q2.service.actor.Actor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ActorRequest {

    private Long id;

    @NotBlank
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date birthDate;

    public Actor toActor() {
        return Actor.builder()
                .id(id)
                .name(name)
                .birthDate(birthDate)
                .build();
    }
}
