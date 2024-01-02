package com.workintech.service;

import com.workintech.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    Movie findById(long id);
    Movie save(Movie movie);
    void delete(Movie movie);

}
