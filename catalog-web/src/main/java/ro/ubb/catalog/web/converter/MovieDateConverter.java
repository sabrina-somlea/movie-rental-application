package ro.ubb.catalog.web.converter;


import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.MovieDate;
import ro.ubb.catalog.web.dto.MovieDateDto;

@Component
public class MovieDateConverter extends BaseConverter<MovieDate, MovieDateDto> {
    @Override
    public MovieDate convertDtoToModel(MovieDateDto dto) {
        MovieDate movieDate = MovieDate.builder()
                .quarter(dto.getQuarter())
                .year(dto.getYear())
                .month(dto.getMonth())
                .day(dto.getDay())
                .build();
        movieDate.setId(dto.getId());
        return movieDate;
    }

    @Override
    public MovieDateDto convertModelToDto(MovieDate movieDate) {
        MovieDateDto dto = MovieDateDto.builder()
                .quarter(movieDate.getQuarter())
                .year(movieDate.getYear())
                .month(movieDate.getMonth())
                .day(movieDate.getDay())
                .build();
        dto.setId(movieDate.getId());
        return dto;
    }
}

