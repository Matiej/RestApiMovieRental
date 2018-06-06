package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.dto.OmbdBlueRayDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OmbdBlueRayMapper {

    public BlueRayMovie mapToBlueRayMovie(final OmbdBlueRayDto ombdBlueRayDto){
        return new BlueRayMovie(
                ombdBlueRayDto.getTitle(),
                ombdBlueRayDto.getImdbID(),
                ombdBlueRayDto.getPoster(),
                "BluRayMovie");
    }

    public List<BlueRayMovie> mapToBlueRayMoviesList(List<OmbdBlueRayDto> blueRayDto){
        List<OmbdBlueRayDto> ombdBlueRayDtoList = Optional.ofNullable(blueRayDto).orElse(new ArrayList<>());
        return ombdBlueRayDtoList.stream()
                .map(b-> new BlueRayMovie(
                        b.getTitle(),
                        b.getImdbID(),
                        b.getPoster(),
                        "BluRayMovie"))
                        .collect(Collectors.toList());
    }


}


