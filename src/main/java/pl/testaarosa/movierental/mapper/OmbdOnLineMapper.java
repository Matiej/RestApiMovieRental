package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OmbdOnLineMapper {

    public OnLineMovie mapToOnLineMovie(OnLineMovieDetails oneLineMovieDto) {
        return new OnLineMovie(oneLineMovieDto.getTitle(),
                oneLineMovieDto.getYear(),
                oneLineMovieDto.getImdbID(),
                oneLineMovieDto.getPoster(),
                "ONLINE MOVIE");
    }

    public List<OnLineMovie> mapToOnLineMovieList(List<OmdbOnLineDto> omdbOnLineDtoList) {
        return omdbOnLineDtoList.stream()
                .map(o -> new OnLineMovie(
                        o.getTitle(),
                        o.getYear(),
                        o.getImdbID(),
                        o.getPoster(),
                        "ONLINE MOVIE"))
                .collect(Collectors.toList());
    }
}
