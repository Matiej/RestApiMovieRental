package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DvdMovieMapper {

    public DvdMovie mapToDvdMovie(DvdMovieDto dvdMovieDto) {
        return DvdMovie.builder()
                .id(dvdMovieDto.getId())
                .imdbID(dvdMovieDto.getImdbID())
                .title(dvdMovieDto.getTitle())
                .countryOfOrigin(dvdMovieDto.getCountryOfOrigin())
                .type(dvdMovieDto.getType())
                .price(dvdMovieDto.getPrice())
                .poster(dvdMovieDto.getPoster())
                .supplier(dvdMovieDto.getSupplier())
                .build();
    }

    public DvdMovieDto mapToDvdMovieDto(DvdMovie dvdMovie) {
        return new DvdMovieDto.Builder()
                .id(dvdMovie.getId())
                .imdbID(dvdMovie.getImdbID())
                .title(dvdMovie.getTitle())
                .countryOfOrigin(dvdMovie.getCountryOfOrigin())
                .type(dvdMovie.getType())
                .price(dvdMovie.getPrice())
                .poster(dvdMovie.getPoster())
                .supplier(dvdMovie.getSupplier())
                .build();
    }

    public List<DvdMovie> mapToDvdList(List<DvdMovieDto> dvdMovieDtos) {
        return dvdMovieDtos.stream()
                .map(m -> DvdMovie.builder()
                        .id(m.getId())
                        .imdbID(m.getImdbID())
                        .title(m.getTitle())
                        .countryOfOrigin(m.getCountryOfOrigin())
                        .type(m.getType())
                        .price(m.getPrice())
                        .poster(m.getPoster())
                        .supplier(m.getSupplier())
                        .build())
                .collect(Collectors.toList());
    }


    public List<DvdMovieDto> mapToDvdDtoList(List<DvdMovie> dvdMovie) {
        return dvdMovie.stream()
                .map(m -> new DvdMovieDto.Builder()
                        .id(m.getId())
                        .imdbID(m.getImdbID())
                        .title(m.getTitle())
                        .countryOfOrigin(m.getCountryOfOrigin())
                        .type(m.getType())
                        .price(m.getPrice())
                        .poster(m.getPoster())
                        .supplier(m.getSupplier())
                        .build())
                .collect(Collectors.toList());
    }
}
