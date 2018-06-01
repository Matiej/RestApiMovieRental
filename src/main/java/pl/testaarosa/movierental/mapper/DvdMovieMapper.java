package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;

@Component
public class DvdMovieMapper {

    public DvdMovie mapToMovieFromSupplierOne(DvdMovieDto dvdMovieDto) {
        return DvdMovie.builder()
                .countryOfOrigin(dvdMovieDto.getCountryOfOrigin())
                .imdbID(dvdMovieDto.getMovieId())
                .type(dvdMovieDto.getFilmGenre())
                .title(dvdMovieDto.getTitle())
                .price(dvdMovieDto.getPrice())
                .poster("http://goshico.com/allegro/questionmarksmall.png")
                .build();
    }

}
