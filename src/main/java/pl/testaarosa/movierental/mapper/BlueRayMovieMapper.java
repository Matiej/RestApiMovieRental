package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlueRayMovieMapper {

    public BlueRayMovie mapToBlueRayMovie(BlueRayMovieDto blueRayMovieDto) {
        return new BlueRayMovie(
                blueRayMovieDto.getTitle(),
                blueRayMovieDto.getImdbID(),
                blueRayMovieDto.getPoster(),
                "BluRayMovie");
    }

    public BlueRayMovieDto mapToBlueRayMovieDto(BlueRayMovie blueRayMovie){
        return new BlueRayMovieDto(
                blueRayMovie.getId(),
                blueRayMovie.getTitle(),
                blueRayMovie.getImdbID(),
                blueRayMovie.getPoster(),
                "BluRayMovie",
                blueRayMovie.getBlueRayMovieDetails());
    }

    public List<BlueRayMovieDto> mapToBlueRayMovieDtoList(List<BlueRayMovie> blueRayMovies) {
        return blueRayMovies.stream()
                .map(b-> new BlueRayMovieDto(
                        b.getId(),
                        b.getTitle(),
                        b.getImdbID(),
                        b.getPoster(),
                        "BluRayMovie",
                        b.getBlueRayMovieDetails()))
                .collect(Collectors.toList());
    }

}
