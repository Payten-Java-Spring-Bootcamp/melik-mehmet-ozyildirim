package dev.melik.bootcamp.week4.q2.controller.member;

import dev.melik.bootcamp.week4.q2.service.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberRequest {

    @NotBlank
    private String name;

    public Member toMember() {
        return Member.builder()
                .name(name)
                .build();
    }
}
