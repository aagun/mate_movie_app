package com.demo.movie.service;

import com.demo.movie.exception.NotFoundException;
import com.demo.movie.model.Movie;
import com.demo.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new NotFoundException(String.format("Movies with id %s is not found", id));
        }
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movieDetails) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + id));

            movie.setTitle(movieDetails.getTitle());
            movie.setDirector(movieDetails.getDirector());
            movie.setSummary(movieDetails.getSummary());
            movie.setGenres(movieDetails.getGenres());

            return movieRepository.save(movie);
        } else {
            throw new IllegalArgumentException("Movie not found with id: " + id);
        }
    }

        @Override
        public String deleteMovie (Long id){
            movieRepository.deleteById(id);
            return String.format("Movie with id %s has been successfully deleted", id);
    }
}
