package dev.melik.bootcamp.week4.q2.repository.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorDAOImpl implements ActorDAO{

    private final ActorJpaRepository actorJpaRepository;

    @Override
    public ActorEntity createActor(ActorEntity actorEntity) {
        return actorJpaRepository.save(actorEntity);
    }

    @Override
    public List<ActorEntity> createActors(List<ActorEntity> actorEntities) {
        return actorJpaRepository.saveAll(actorEntities);
    }

    @Override
    public List<ActorEntity> getActorsById(List<Long> ids) {
        return actorJpaRepository.findByIdIn(ids);
    }

    @Override
    public ActorEntity getById(Long actorId) {
        Optional<ActorEntity> optionalActorEntity=actorJpaRepository.findById(actorId);
        if (optionalActorEntity.isPresent()){
            return optionalActorEntity.get();
        }else {
            throw new EntityNotFoundException("Actor with id "+actorId+" not found.");
        }
    }
}
