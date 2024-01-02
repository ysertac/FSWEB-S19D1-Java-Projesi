package com.workintech.dto;

import com.workintech.entity.Actor;
import com.workintech.entity.Movie;
import lombok.Data;

import java.util.List;

@Data
public class ActorRequest {

    private List<Movie> movies;
    private Actor actor;

}
