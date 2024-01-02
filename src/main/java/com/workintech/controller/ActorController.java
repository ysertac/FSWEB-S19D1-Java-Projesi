package com.workintech.controller;

import com.workintech.dto.ActorRequest;
import com.workintech.dto.ActorResponse;
import com.workintech.entity.Actor;
import com.workintech.entity.Movie;
import com.workintech.service.ActorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<ActorResponse> findAll() {
        List<Actor> allActors = actorService.findAll();
        List<ActorResponse> actors = new ArrayList<>();
        for (Actor actor : allActors) {
            actors.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), null));
        }
        return actors;
    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable long id) {
        Actor actor = actorService.findById(id);
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), null);
    }

    @PostMapping
    public ActorResponse save(@Validated @RequestBody ActorRequest actorRequest) {
        List<Movie> movies = actorRequest.getMovies();
        Actor actor = actorRequest.getActor();
        for (Movie movie : movies) {
            actor.addMovie(movie);
        }
        actorService.save(actor);
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getMovies());
    }

    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor, @PathVariable long id) {
        Actor foundActor = actorService.findById(id);
        foundActor.setMovies(actor.getMovies());
        foundActor.setId(id);
        actorService.save(foundActor);
        return new ActorResponse(foundActor.getId(), foundActor.getFirstName(), foundActor.getLastName(), foundActor.getMovies());
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable long id) {
        Actor foundActor = actorService.findById(id);
        actorService.delete(foundActor);
        return new ActorResponse(foundActor.getId(), foundActor.getFirstName(), foundActor.getLastName(), foundActor.getMovies());
    }
}
