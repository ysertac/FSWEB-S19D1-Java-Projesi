package com.workintech.dto;

import com.workintech.entity.Movie;

import java.util.List;

public record ActorResponse(long id, String firstName, String lastName, List<Movie> movies) {

}
