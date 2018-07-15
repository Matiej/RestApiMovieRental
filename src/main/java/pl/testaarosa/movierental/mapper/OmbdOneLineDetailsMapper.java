package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDetailsDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OmbdOneLineDetailsMapper {

    public OnLineMovieDetails mapToOnLineMovieDetails(OmdbOnLineDetailsDto omdbOnLineDetailsDto){

        return new OnLineMovieDetails(
                omdbOnLineDetailsDto.getImdbID(),
                omdbOnLineDetailsDto.getTitle(),
                omdbOnLineDetailsDto.getYear(),
                omdbOnLineDetailsDto.getReleased(),
                omdbOnLineDetailsDto.getRuntime(),
                omdbOnLineDetailsDto.getGenre(),
                omdbOnLineDetailsDto.getWriter(),
                omdbOnLineDetailsDto.getActors(),
                omdbOnLineDetailsDto.getPlot(),
                omdbOnLineDetailsDto.getLanguage(),
                omdbOnLineDetailsDto.getCountry(),
                omdbOnLineDetailsDto.getAwards(),
                omdbOnLineDetailsDto.getPoster(),
                omdbOnLineDetailsDto.getProduction());
    }

    public List<OnLineMovieDetails> mapToOnlineMovieDetails(List<OmdbOnLineDetailsDto> detailsDtos) {
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
