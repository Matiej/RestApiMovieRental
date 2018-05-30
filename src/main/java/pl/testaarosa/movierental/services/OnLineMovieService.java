package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;

import java.util.List;

public interface OnLineMovieService {
    List<OnLineMovie> getOnLineMovies(String title);
    OnLineMovieDetails getOnLineMovieDetails(String movieId);
}
