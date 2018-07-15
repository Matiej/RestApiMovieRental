package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.dto.OmdbBlueRayDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OmbdBlueRayMapper {

    public BlueRayMovie mapToBlueRayMovie(final OmdbBlueRayDto omdbBlueRayDto){
        return new BlueRayMovie(
                omdbBlueRayDto.getTitle(),
                omdbBlueRayDto.getImdbID(),
                omdbBlueRayDto.getPoster(),
                "BlueRayMovie");
    }

    public List<BlueRayMovie> mapToBlueRayMoviesList(List<OmdbBlueRayDto> blueRayDto){
        List<OmdbBlueRayDto> omdbBlueRayDtoList = Optional.ofNullable(blueRayDto).orElse(new ArrayList<>());
        return omdbBlueRayDtoList.stream()
                .map(b-> new BlueRayMovie(
                        b.getTitle(),
                        b.getImdbID(),
                        b.getPoster(),
                        "BlueRayMovie"))
                        .collect(Collectors.toList());
    }


}


