package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface OnLineMovieService {
    List<OnLineMovie> getOnLineMovies(String title) throws ExecutionException, InterruptedException;
    OnLineMovieDetails getOnLineMovieDetails(String movieId) throws ExecutionException, InterruptedException;
    OnLineMovie addOnLineMovieToDb(String imbdId) throws ExecutionException, InterruptedException, MovieNotFoundException;
    OnLineMovie findById(Long id) throws MovieNotFoundException;
}
