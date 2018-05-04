package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.controller.OnLineMovieController;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BlueRayMovieMapper {

    public BlueRayMovie mapToMovieFromSupplierTwo(final BlueRayMovieDto blueRayMovieDto){
        return BlueRayMovie.builder()
                .imdbID(blueRayMovieDto.getImdbID())
                .title(blueRayMovieDto.getTitle())
                .type(blueRayMovieDto.getYear())
                .year(blueRayMovieDto.getYear())
                .poster(blueRayMovieDto.getPoster())
                .build();
    }

    public List<BlueRayMovie> mapToBlueRayMoviesList(List<BlueRayMovieDto> blueRayDto){
        List<BlueRayMovieDto> blueRayMovieDtoList = Optional.ofNullable(blueRayDto).orElse(new ArrayList<>());
        return blueRayMovieDtoList.stream()
                .map(b-> BlueRayMovie.builder()
                        .imdbID(b.getImdbID())
                        .title(b.getTitle())
                        .type(b.getType())
                        .year(b.getYear())
                        .poster(b.getPoster())
                        .build())
                        .collect(Collectors.toList());
    }


}


