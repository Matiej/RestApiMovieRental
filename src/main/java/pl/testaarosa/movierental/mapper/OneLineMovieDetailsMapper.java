package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OneLineMovieDetailsMapper {

    public OnLineMovieDetails mapToOnLineMovieDetails(OnLineMovieDetailsDto onLineMovieDetailsDto){

        return new OnLineMovieDetails(
                onLineMovieDetailsDto.getImdbID(),
                onLineMovieDetailsDto.getTitle(),
                onLineMovieDetailsDto.getYear(),
                onLineMovieDetailsDto.getReleased(),
                onLineMovieDetailsDto.getRuntime(),
                onLineMovieDetailsDto.getGenre(),
                onLineMovieDetailsDto.getWriter(),
                onLineMovieDetailsDto.getActors(),
                onLineMovieDetailsDto.getPlot(),
                onLineMovieDetailsDto.getLanguage(),
                onLineMovieDetailsDto.getCountry(),
                onLineMovieDetailsDto.getAwards(),
                onLineMovieDetailsDto.getPoster(),
                onLineMovieDetailsDto.getProduction());
    }

    public List<OnLineMovieDetails> mapToOnlineMovieDetails(List<OnLineMovieDetailsDto> detailsDtos) {
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
