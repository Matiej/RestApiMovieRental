package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.mapper.OmbdOnLineMapper;
import pl.testaarosa.movierental.repositories.OnLineMovieRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class OnLineMovieServiceImpl implements OnLineMovieService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnLineMovieServiceImpl.class);
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

    @Transactional
    @Override
    public OnLineMovie addOnLineMovieToDb(String imdbID) throws ExecutionException, InterruptedException, MovieNotFoundException {
        CompletableFuture<OnLineMovieDetails> onLineMovieDetails = onLineMovieRetriever.getOnLineMovieDetails(imdbID);
        CompletableFuture.allOf(onLineMovieDetails);
        if (Optional.ofNullable(onLineMovieDetails.get().getImdbID()).isPresent()) {
            OnLineMovie onLineMovie = onLineMovieMapper.mapToOnLineMovie(onLineMovieDetails.get());
            if (!onLineMovieRepository.existsAllByImdbID(imdbID)) {
                onLineMovie.setOnLineMovieDetails(onLineMovieDetails.get());
                onLineMovieRepository.save(onLineMovie);
                return onLineMovie;
            } else {
                return onLineMovieRepository.findByImdbID(imdbID);
            }
        } else {
            LOGGER.error("Wrong imdbID, can't fine movie with id: -> " + imdbID);
            throw new MovieNotFoundException("Wrong imdbID, can't fine movie with id: -> " + imdbID);
        }
    }

    @Override
    public OnLineMovie findById(Long id) throws MovieNotFoundException {
        OnLineMovie onLine = null;
        if (Optional.ofNullable(onLineMovieRepository.findOne(id)).isPresent()) {
            return onLineMovieRepository.findOne(id);
        } else {
            LOGGER.error("\u001B[31mNo online movie found!!\u001B[0m");
            throw new MovieNotFoundException("No online movie found");
        }
    }
}
