package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.mapper.OmbdOnLineMapper;
import pl.testaarosa.movierental.repositories.OnLineMovieRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class OnLineMovieServiceImpl implements OnLineMovieService {

    @Autowired
    private OnLineMovieRetriever onLineMovieRetriever;
    @Autowired
    private OnLineMovieRepository onLineMovieRepository;
    @Autowired
    private OmbdOnLineMapper onLineMovieMapper;

    @Override
    public List<OnLineMovie> getOnLineMovies(String title) throws ExecutionException, InterruptedException {
        CompletableFuture<List<OnLineMovie>> onLine = onLineMovieRetriever.getOnLineMovies(title);
        CompletableFuture.allOf(onLine);
            return onLine.get();
    }

    @Override
    public OnLineMovieDetails getOnLineMovieDetails(String movieId) throws ExecutionException, InterruptedException {
        CompletableFuture<OnLineMovieDetails> onLineMovieDetails = onLineMovieRetriever.getOnLineMovieDetails(movieId);
        CompletableFuture.allOf(onLineMovieDetails);
        return onLineMovieDetails.get();
    }

    @Override
    public OnLineMovie addOnLineMovieToDb(String imdbID) throws ExecutionException, InterruptedException {
        CompletableFuture<OnLineMovieDetails> onLineMovieDetails = onLineMovieRetriever.getOnLineMovieDetails(imdbID);
        CompletableFuture.allOf(onLineMovieDetails);
        OnLineMovie onLineMovie = onLineMovieMapper.mapToOnLineMovie(onLineMovieDetails.get());
        if(!onLineMovieRepository.existsAllByImdbID(imdbID)) {
            onLineMovie.setOnLineMovieDetails(onLineMovieDetails.get());
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
