package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.DvdMovieDetails;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OneDvdDetilsMapper {

    public List<DvdMovieDetails> mapToOneDvdMovieDetails(List<OneDvdDto> oneDvdDto) {
        return oneDvdDto.stream()
                .map(d -> new DvdMovieDetails(
                        d.getMovieId(),
                        d.getTitle(),
                        d.getCountryOfOrigin(),
                        d.getFilmGenre(),
                        d.getPrice(),
                        "http://goshico.com/allegro/questionmarksmall.png",
                        "DVD MOVIE"))
                .collect(Collectors.toList());
    }

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
