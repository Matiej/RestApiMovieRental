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
                blueRayMovieDto.getYear(),
                blueRayMovieDto.getImdbID(),
                blueRayMovieDto.getType(),
                blueRayMovieDto.getPoster(),
                "BluRayMovie");
    }

    public BlueRayMovieDto mapToBlueRayMovieDto(BlueRayMovie blueRayMovieDto){
        return new BlueRayMovieDto(
                blueRayMovieDto.getId(),
                blueRayMovieDto.getTitle(),
                blueRayMovieDto.getYear(),
                blueRayMovieDto.getImdbID(),
                blueRayMovieDto.getType(),
                blueRayMovieDto.getPoster(),
                "BluRayMovie",
                blueRayMovieDto.getBlueRayMovieDetails());
    }

    public List<BlueRayMovieDto> mapToBlueRayMovieDtoList(List<BlueRayMovie> blueRayMovies) {
        return blueRayMovies.stream()
                .map(b-> new BlueRayMovieDto(
                        b.getId(),
                        b.getTitle(),
                        b.getYear(),
                        b.getImdbID(),
                        b.getType(),
                        b.getPoster(),
                        "BluRayMovie",
                        b.getBlueRayMovieDetails()))
                .collect(Collectors.toList());
    }

}
