package dev.melik.bootcamp.week3.q2.service.member;

import dev.melik.bootcamp.week3.q2.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberDAO memberDAO;

    @Override
    public Member createMember(Member member) {
        return Member.fromEntity(memberDAO.createMember(member.toEntity()));
    }
}
