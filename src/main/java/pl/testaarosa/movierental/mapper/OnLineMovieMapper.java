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
                onLineMovie.getYear(),
                onLineMovie.getTitle(),
                onLineMovie.getImdbID(),
                onLineMovie.getPoster(),
                onLineMovie.getSupplier(),
                onLineMovie.getOnLineMovieDetails());
    }

    public List<OnLineMovieDto> mapToOnLineMovieDtoList(List<OnLineMovie> onLineMovies) {
        return onLineMovies.stream()
                .map(o -> new OnLineMovieDto(
                        o.getId(),
                        o.getYear(),
                        o.getTitle(),
                        o.getImdbID(),
                        o.getPoster(),
                        o.getSupplier(),
                        o.getOnLineMovieDetails()))
                .collect(Collectors.toList());
    }
}
