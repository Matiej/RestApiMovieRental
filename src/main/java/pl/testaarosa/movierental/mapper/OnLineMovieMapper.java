package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.dto.OmbdOnLineDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OnLineMovieMapper {

    public OnLineMovie mapToOnLineMovie(OmbdOnLineDto oneLineMovieDto) {
        return new OnLineMovie(oneLineMovieDto.getTitle(),
                oneLineMovieDto.getYear(),
                oneLineMovieDto.getImdbID(),
                oneLineMovieDto.getType(),
                oneLineMovieDto.getPoster());
    }

    public List<OnLineMovie> mapToOnLineMovieList(List<OmbdOnLineDto> ombdOnLineDtoList) {
        return ombdOnLineDtoList.stream()
                .map(o -> new OnLineMovie(
                        o.getTitle(),
                        o.getYear(),
                        o.getImdbID(),
                        o.getType(),
                        o.getPoster()))
                .collect(Collectors.toList());
    }
}
