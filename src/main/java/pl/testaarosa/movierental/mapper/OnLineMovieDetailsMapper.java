package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;

@Component
public class OnLineMovieDetailsMapper {

    public OnLineMovieDetailsDto mapToOnLineDetalisDto(OnLineMovieDetails onLineMovieDetails) {
        return new OnLineMovieDetailsDto(
                onLineMovieDetails.getId(),
                onLineMovieDetails.getImdbID(),
                onLineMovieDetails.getTitle(),
                onLineMovieDetails.getYear(),
                onLineMovieDetails.getReleased(),
                onLineMovieDetails.getRuntime(),
                onLineMovieDetails.getGenre(),
                onLineMovieDetails.getWriter(),
                onLineMovieDetails.getActors(),
                onLineMovieDetails.getPlot(),
                onLineMovieDetails.getLanguage(),
                onLineMovieDetails.getCountry(),
                onLineMovieDetails.getAwards(),
                onLineMovieDetails.getPoster(),
                onLineMovieDetails.getProduction());
    }
}
