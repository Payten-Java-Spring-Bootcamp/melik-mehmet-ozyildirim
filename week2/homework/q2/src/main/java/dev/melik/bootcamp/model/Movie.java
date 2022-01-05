package dev.melik.bootcamp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Builder
public class Movie {

    public enum Genre {
        ACTION,
        HORROR,
        COMEDY,
        ROMANCE
    }

    private Long id;

    @NotBlank
    private String name;

    private Genre genre;

    private Integer releaseYear;

    private String director;

    private List<String> cast;

    private Double point;

}
