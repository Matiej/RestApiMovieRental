package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

import java.util.List;

public interface BlueRayMovieService {
    void addBlueRayMovies(BlueRayMovie blueRayMovie,
                          BlueRayMovieDetails blueRayMovieDetails);
    List<BlueRayMovie> findAll();
    BlueRayMovie findbyId(Long id);
    List<BlueRayMovie> findAllContainsTitle(String title);
}
