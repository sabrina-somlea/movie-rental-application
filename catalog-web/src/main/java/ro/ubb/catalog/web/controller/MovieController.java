package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Movie;
import ro.ubb.catalog.core.service.MovieService;
import ro.ubb.catalog.web.converter.MovieConverter;
import ro.ubb.catalog.web.dto.MovieDto;
import ro.ubb.catalog.web.dto.MovieDtos;


import java.util.List;
import java.util.Set;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value = "/moviesSet")
    Set<MovieDto> getAllMoviesSet() {
        List<Movie> allMovies = movieService.getAllMovies();
        Set<MovieDto> movieDto = movieConverter.convertModelsToDtos(allMovies);
        MovieDtos dtos = new MovieDtos(movieDto);
        return movieDto;
    }

    @RequestMapping(value = "/movies")
    MovieDtos getAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        Set<MovieDto> movieDto = movieConverter.convertModelsToDtos(allMovies);
        MovieDtos dtos = new MovieDtos(movieDto);
        return dtos;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    MovieDto saveMovie(@RequestBody MovieDto movieDto) {
        Movie movie = movieConverter.convertDtoToModel(movieDto);
        Movie savedMovie = movieService.saveMovie(movie);
        return movieConverter.convertModelToDto(savedMovie);
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    MovieDto updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        return movieConverter.convertModelToDto(
                movieService.updateMovie(id,
                        movieConverter.convertDtoToModel(movieDto))
        );
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
