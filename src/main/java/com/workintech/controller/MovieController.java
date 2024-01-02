package com.workintech.controller;

import com.workintech.dto.MovieResponse;
import com.workintech.entity.Movie;
import com.workintech.service.MovieService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponse> findAll() {
        List<Movie> allMovies = movieService.findAll();
        List<MovieResponse> movies = new ArrayList<>();
        for (Movie m : allMovies) {
            movies.add(new MovieResponse(m.getId(), m.getName(), m.getRating()));
        }
        return movies;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable long id) {
        Movie movie = movieService.findById(id);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getRating());
    }

    @PostMapping
    public MovieResponse save(@Validated @RequestBody Movie movie) {
        movieService.save(movie);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getRating());
    }

}
