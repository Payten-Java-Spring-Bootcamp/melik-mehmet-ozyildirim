package dev.melik.bootcamp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Member {

    private Long id;

    private String name;

}
