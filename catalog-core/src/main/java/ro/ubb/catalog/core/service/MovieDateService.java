package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.MovieDate;

import java.util.List;

public interface MovieDateService {
    List<MovieDate> getAllMovieDates();
    MovieDate saveMovieDate(MovieDate movieDate);
    MovieDate updateMovieDate(Long id, MovieDate movieDate);
    void deleteMovieDate(Long id);
}
