package com.workintech.service;

import com.workintech.entity.Actor;
import com.workintech.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();
    Actor findById(long id);
    Actor save(Actor actor);
    void delete (Actor actor);

}
