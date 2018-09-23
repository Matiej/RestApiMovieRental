package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDetailsDto;

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
}
