package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

import java.util.List;

public interface OnLineMovieService {
    List<BlueRayMovie> getOnLineMovies(String title);
    BlueRayMovieDetails getOnLineMovieDetails(String movieId);
}
