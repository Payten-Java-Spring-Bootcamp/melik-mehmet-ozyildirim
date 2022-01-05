package dev.melik.bootcamp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
public class WatchList {

    private Long id;

    @NotNull
    private Member member;

    @NotBlank
    private String name;

    private List<Movie> movies;
}
