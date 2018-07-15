package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.mapper.OmbdOnLineMapper;
import pl.testaarosa.movierental.mapper.OmbdOneLineDetailsMapper;
import pl.testaarosa.movierental.mapper.OnLineMovieMapper;
import pl.testaarosa.movierental.repositories.OnLineMovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnLineMovieServiceImpl implements OnLineMovieService {

    @Autowired
    private OnLineMovieRetriever onLineMovieRetriever;
    @Autowired
    private OnLineMovieRepository onLineMovieRepository;
    @Autowired
    private OmbdOnLineMapper onLineMovieMapper;

    @Override
    public List<OnLineMovie> getOnLineMovies(String title){
            return onLineMovieRetriever.getOnLineMovies(title);
    }

    @Override
    public OnLineMovieDetails getOnLineMovieDetails(String movieId){
        return onLineMovieRetriever.getOnLineMovieDetails(movieId);
    }

    @Override
    public OnLineMovie addOnLineMovieToDb(String imdbID) {
        OnLineMovieDetails onLineMovieDetails = onLineMovieRetriever.getOnLineMovieDetails(imdbID);
        OnLineMovie onLineMovie = onLineMovieMapper.mapToOnLineMovie(onLineMovieDetails);
        if(!onLineMovieRepository.existsAllByImdbID(imdbID)) {
            onLineMovie.setOnLineMovieDetails(onLineMovieDetails);
            onLineMovieRepository.save(onLineMovie);
            return onLineMovie;
        } else {
            return onLineMovieRepository.findByImdbID(imdbID);
        }
    }

    @Override
    public OnLineMovie findById(Long id) {
        return onLineMovieRepository.findOne(id);
    }
}
