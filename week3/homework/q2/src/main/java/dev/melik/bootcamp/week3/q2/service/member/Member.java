package dev.melik.bootcamp.week3.q2.service.member;

import dev.melik.bootcamp.week3.q2.repository.member.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Member {
    private Long id;

    private String name;

    public static Member fromEntity(MemberEntity member) {
        return Member.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }

    public MemberEntity toEntity() {
        MemberEntity memberEntity=new MemberEntity();
        memberEntity.setId(id);
        memberEntity.setName(name);
        return memberEntity;
    }
}
