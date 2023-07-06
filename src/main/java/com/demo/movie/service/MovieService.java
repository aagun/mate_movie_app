package com.demo.movie.service;

import com.demo.movie.model.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> getAllMovie();
    public Movie createMovie(Movie movie);
    public Movie getMovieById(Long id);
    public Movie updateMovie(Long id, Movie updatedMovie);
    public String deleteMovie(Long id);
}
