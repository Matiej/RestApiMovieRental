package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.Movie;

public interface MovieService {

    Movie findById(Long id) throws MovieNotFoundException;
}
