package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OnLineMovieMapper {

    public OnLineMovieDto mapToOnlineMovieDto(OnLineMovie onLineMovie) {
        return new OnLineMovieDto(
                onLineMovie.getId(),
                onLineMovie.getTitle(),
                onLineMovie.getYear(),
                onLineMovie.getImdbID(),
                onLineMovie.getType(),
                onLineMovie.getPoster(),
                onLineMovie.getSupplier(),
                onLineMovie.getOnLineMovieDetails());
    }

    public List<OnLineMovieDto> mapToOnLineMovieDtoList(List<OnLineMovie> onLineMovies) {
        return onLineMovies.stream()
                .map(o -> new OnLineMovieDto(
                        o.getId(),
                        o.getTitle(),
                        o.getYear(),
                        o.getImdbID(),
                        o.getType(),
                        o.getPoster(),
                        o.getSupplier(),
                        o.getOnLineMovieDetails()))
                .collect(Collectors.toList());
    }
}
