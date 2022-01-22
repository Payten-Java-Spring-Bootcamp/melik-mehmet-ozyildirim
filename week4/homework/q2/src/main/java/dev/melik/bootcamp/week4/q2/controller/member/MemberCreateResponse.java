package dev.melik.bootcamp.week4.q2.controller.member;

import dev.melik.bootcamp.week4.q2.service.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MemberCreateResponse {

    private Long id;

    private String name;

    public static MemberCreateResponse fromMember(Member member) {
        return MemberCreateResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }
}
