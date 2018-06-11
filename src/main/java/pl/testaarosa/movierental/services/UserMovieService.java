package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.form.UserMovieForm;

import java.util.List;

public interface UserMovieService {
    List<UserMovie> findAll();
    UserMovie finaOne(Long id);
    UserMovie add(Long id, UserMovieForm userMovie);
    void delete(Long id);
    List<UserMovie> findAllByTitleContaining(String title);
}
