package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.mapper.OnLineMovieDetailsMapper;
import pl.testaarosa.movierental.mapper.OnLineMovieMapper;
import pl.testaarosa.movierental.services.OnLineMovieService;

import java.util.List;

@Service
public class OnLineMovieFacade {

    @Autowired
    private OnLineMovieService onLineMovieService;
    @Autowired
    private OnLineMovieMapper mapper;
    @Autowired
    private OnLineMovieDetailsMapper detailsMapper;


    public List<OnLineMovieDto> getOnLineMovies(String title){
        return mapper.mapToOnLineMovieDtoList(onLineMovieService.getOnLineMovies(title));
    }

    public OnLineMovieDetailsDto getOnLineMovieDetails(String movieId) {
        return detailsMapper.mapToOnLineDetalisDto(onLineMovieService.getOnLineMovieDetails(movieId));
    }
}
