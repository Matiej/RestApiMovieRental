package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.dto.OmbdBlueRayDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BlueRayMovieMapper {

    public BlueRayMovie mapToBlueRayMovie(final OmbdBlueRayDto ombdBlueRayDto){
        return BlueRayMovie.builder()
                .imdbID(ombdBlueRayDto.getImdbID())
                .title(ombdBlueRayDto.getTitle())
                .type(ombdBlueRayDto.getYear())
                .year(ombdBlueRayDto.getYear())
                .poster(ombdBlueRayDto.getPoster())
                .build();
    }

    public List<BlueRayMovie> mapToBlueRayMoviesList(List<OmbdBlueRayDto> blueRayDto){
        List<OmbdBlueRayDto> ombdBlueRayDtoList = Optional.ofNullable(blueRayDto).orElse(new ArrayList<>());
        return ombdBlueRayDtoList.stream()
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


