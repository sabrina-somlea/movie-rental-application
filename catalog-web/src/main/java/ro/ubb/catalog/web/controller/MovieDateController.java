package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.MovieDate;
import ro.ubb.catalog.core.service.MovieDateService;
import ro.ubb.catalog.web.converter.MovieDateConverter;
import ro.ubb.catalog.web.dto.MovieDateDto;
import ro.ubb.catalog.web.dto.MovieDateDtos;

import java.util.List;
import java.util.Set;

@RestController
public class MovieDateController {
    @Autowired
    private MovieDateService movieDateService;
    @Autowired
    private MovieDateConverter movieDateConverter;

    @RequestMapping(value = "/moviedate")
    Set<MovieDateDto> getAllMovieDates() {
        List<MovieDate> allMovieDates = movieDateService.getAllMovieDates();
        Set<MovieDateDto> movieDateDtos = movieDateConverter.convertModelsToDtos(allMovieDates);
        MovieDateDtos dtos = new MovieDateDtos(movieDateDtos);
        return movieDateDtos;
    }

    @RequestMapping(value = "/moviedate", method = RequestMethod.POST)
    MovieDateDto saveMovieDate(@RequestBody MovieDateDto movieDateDto) {
        MovieDate movieDate = movieDateConverter.convertDtoToModel(movieDateDto);
        MovieDate savedMovieDate = movieDateService.saveMovieDate(movieDate);
        return movieDateConverter.convertModelToDto(savedMovieDate);
    }

    @RequestMapping(value = "/moviedate/{id}", method = RequestMethod.PUT)
    MovieDateDto updateMovieDate(@PathVariable Long id, @RequestBody MovieDateDto movieDateDto) {
        return movieDateConverter.convertModelToDto(
                movieDateService.updateMovieDate(id,
                        movieDateConverter.convertDtoToModel(movieDateDto))
        );
    }

    @RequestMapping(value = "/moviedate/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteMovieDateById(@PathVariable Long id) {
        movieDateService.deleteMovieDate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
