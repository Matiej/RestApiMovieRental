package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDetailsDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.mapper.BlueRayMovieDetailsMapper;
import pl.testaarosa.movierental.mapper.BlueRayMovieMapper;
import pl.testaarosa.movierental.mapper.OnLineMovieMapper;
import pl.testaarosa.movierental.mapper.OneLineMovieDetailsMapper;

import java.util.List;

@Service
public class OnLineMovieServiceImpl implements OnLineMovieService {

    @Autowired
    private BlueRayMovieRetriever blueRayMovieRetriever;
    @Autowired
    private OnLineMovieMapper onLineMovieMapper;
    @Autowired
    private OneLineMovieDetailsMapper oneLineMovieDetailsMapper;
    @Autowired
    private OnLineMovieRetriever onLineMovieRetriever;

    @Override
    public List<OnLineMovie> getOnLineMovies(String title){
        List<OnLineMovieDto> onLineMovieDtos = onLineMovieRetriever.getPaginationOnlineLine(title);
        return onLineMovieMapper.mapToOnLineMovieList(onLineMovieDtos);
    }

    @Override
    public OnLineMovieDetails getOnLineMovieDetails(String movieId){
        BlueRayMovieDetailsDto movieDetails = blueRayMovieRetriever.getMovieDetails(movieId);
        OnLineMovieDetailsDto onLineMovieDetails = onLineMovieRetriever.getOnLineMovieDetails(movieId);
        return oneLineMovieDetailsMapper.mapToOnLineMovieDetails(onLineMovieDetails);
    }

}
