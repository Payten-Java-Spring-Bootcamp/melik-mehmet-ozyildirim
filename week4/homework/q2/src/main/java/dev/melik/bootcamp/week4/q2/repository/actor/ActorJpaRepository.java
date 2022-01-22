package dev.melik.bootcamp.week4.q2.repository.actor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ActorJpaRepository extends JpaRepository<ActorEntity, Long> {

    List<ActorEntity> findByIdIn(List<Long> ids);

}
