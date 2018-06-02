package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmbdOnLineDetailsDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OneLineMovieDetailsMapper {

    public OnLineMovieDetails mapToOnLineMovieDetails(OmbdOnLineDetailsDto ombdOnLineDetailsDto){

        return new OnLineMovieDetails(
                ombdOnLineDetailsDto.getImdbID(),
                ombdOnLineDetailsDto.getTitle(),
                ombdOnLineDetailsDto.getYear(),
                ombdOnLineDetailsDto.getReleased(),
                ombdOnLineDetailsDto.getRuntime(),
                ombdOnLineDetailsDto.getGenre(),
                ombdOnLineDetailsDto.getWriter(),
                ombdOnLineDetailsDto.getActors(),
                ombdOnLineDetailsDto.getPlot(),
                ombdOnLineDetailsDto.getLanguage(),
                ombdOnLineDetailsDto.getCountry(),
                ombdOnLineDetailsDto.getAwards(),
                ombdOnLineDetailsDto.getPoster(),
                ombdOnLineDetailsDto.getProduction());
    }

    public List<OnLineMovieDetails> mapToOnlineMovieDetails(List<OmbdOnLineDetailsDto> detailsDtos) {
        return detailsDtos.stream()
                .map(o-> new OnLineMovieDetails(
                        o.getImdbID(),
                        o.getTitle(),
                        o.getYear(),
                        o.getReleased(),
                        o.getRuntime(),
                        o.getGenre(),
                        o.getWriter(),
                        o.getActors(),
                        o.getPlot(),
                        o.getLanguage(),
                        o.getCountry(),
                        o.getAwards(),
                        o.getPoster(),
                        o.getProduction()))
                .collect(Collectors.toList());
    }
}
