package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Movie;
import ro.ubb.catalog.core.repository.MovieRepository;


import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        log.trace("getAllMovies - method finished: result={}", movieList);
        return movieList;

    }

    @Override
    public Movie saveMovie(Movie movie) {
        log.trace("saveMovie - method entered: movie={} ", movie);

        Movie saveMovie = movieRepository.save(movie);

        log.trace("saveMovie - method finished: result={}", saveMovie);

        return saveMovie;
    }

    @Transactional
    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie updateMovie = movieRepository.findById(id).orElseThrow();

        updateMovie.setTitle(movie.getTitle());
        updateMovie.setReleaseYear(movie.getReleaseYear());
        updateMovie.setLanguage(movie.getLanguage());
        updateMovie.setRating(movie.getRating());
        updateMovie.setRentalPrice(movie.getRentalPrice());

        return updateMovie;
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
