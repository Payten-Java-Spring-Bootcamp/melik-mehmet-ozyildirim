package dev.melik.bootcamp.week4.q2.repository.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public MemberEntity createMember(MemberEntity memberEntity) {
        return memberJpaRepository.save(memberEntity);
    }
}
