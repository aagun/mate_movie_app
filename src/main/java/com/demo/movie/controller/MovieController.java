package com.demo.movie.controller;

import com.demo.movie.model.Movie;
import com.demo.movie.service.MovieService;
import com.demo.movie.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {this.movieService = movieService;
    }

    @GetMapping(value  = "/{id}")
    public ResponseEntity<WebResponse<Movie>> getMovieById(@PathVariable("id") Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new WebResponse<>(String.format("Movie with id %s is found", id), movie));
    }

    @GetMapping(value = "/listMovie")
    public ResponseEntity<WebResponse<List<Movie>>> getAllMovie(){
        List<Movie> listMovies = movieService.getAllMovie();
        return ResponseEntity.status(HttpStatus.OK).body(new WebResponse<>(String.format("List All Movies : "), listMovies));
    }


    @PostMapping
    public ResponseEntity<WebResponse<Movie>> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(new WebResponse<>("Data has been created", movie));
    }

    @PutMapping(value  = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody Movie updatedMovie) {
        try {
            Movie updated = movieService.updateMovie(id, updatedMovie);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping(value  = "/{id}")
    public String deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
