package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.MovieDate;
import ro.ubb.catalog.core.repository.MovieDateRepository;

import java.util.List;
@Service
public class MovieDateServiceImpl implements MovieDateService{
    private static final Logger log = LoggerFactory.getLogger(MovieDateServiceImpl.class);

    @Autowired
    private MovieDateRepository movieDateRepository;

    @Override
    public List<MovieDate> getAllMovieDates() {
        List<MovieDate> movieDateList = movieDateRepository.findAll();
        return movieDateList;
    }

    @Override
    public MovieDate saveMovieDate(MovieDate movieDate) {
        log.trace("saveMovieDate - method entered: movieDate={} ", movieDate);
        MovieDate saveMovieDate = movieDateRepository.save(movieDate);
        log.trace("saveMovieDate - method finished: result={}", saveMovieDate);
        return saveMovieDate;
    }

    @Transactional
    @Override
    public MovieDate updateMovieDate(Long id, MovieDate movieDate) {
        MovieDate updateMovieDate = movieDateRepository.findById(id).orElseThrow();

        updateMovieDate.setQuarter(movieDate.getQuarter());
        updateMovieDate.setYear(movieDate.getYear());
        updateMovieDate.setMonth(movieDate.getMonth());
        updateMovieDate.setDay(movieDate.getDay());

        return updateMovieDate;
    }

    @Override
    public void deleteMovieDate(Long id) {
        movieDateRepository.deleteById(id);
    }
}
