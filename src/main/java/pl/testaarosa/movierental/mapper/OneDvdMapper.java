package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;

@Component
public class OneDvdMapper {

    public DvdMovie mapToDvdMovie(OneDvdDto oneDvdDto) {
        return DvdMovie.builder()
                .countryOfOrigin(oneDvdDto.getCountryOfOrigin())
                .imdbID(oneDvdDto.getMovieId())
                .type(oneDvdDto.getFilmGenre())
                .title(oneDvdDto.getTitle())
                .price(oneDvdDto.getPrice())
                .poster("http://goshico.com/allegro/questionmarksmall.png")
                .build();
    }

}
