package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.DvdMovieDetails;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;

@Component
public class OneDvdDetilsMapper {

    public DvdMovieDetails matpToOneDvdDetails(OneDvdDto oneDvdDto){
        return new DvdMovieDetails(
                oneDvdDto.getMovieId(),
                oneDvdDto.getTitle(),
                oneDvdDto.getCountryOfOrigin(),
                oneDvdDto.getFilmGenre(),
                oneDvdDto.getPrice(),
                "http://goshico.com/allegro/questionmarksmall.png",
                "DVD MOVIE");
    }
}
