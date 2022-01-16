package dev.melik.bootcamp.week3.q2.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}
