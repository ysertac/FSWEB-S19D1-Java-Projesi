package com.workintech.service;

import com.workintech.entity.Actor;
import com.workintech.exceptions.ApiException;
import com.workintech.repository.ActorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if (optionalActor.isPresent()) {
            return optionalActor.get();
        }
        throw new ApiException("actor is not found: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Actor actor) {
        actorRepository.delete(actor);
    }
}
