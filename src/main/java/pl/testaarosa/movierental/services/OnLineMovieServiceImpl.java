package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnLineMovieServiceImpl implements OnLineMovieService {

    @Autowired
    private OnLineMovieRetriever onLineMovieRetriever;

    @Override
    public List<OnLineMovie> getOnLineMovies(String title){
            return onLineMovieRetriever.getOnLineMovies(title);
    }

    @Override
    public OnLineMovieDetails getOnLineMovieDetails(String movieId){
        return onLineMovieRetriever.getOnLineMovieDetails(movieId);
    }

}
