package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.form.UserMovieForm;

import java.util.List;
import java.util.Optional;

public interface UserMovieService {
    List<UserMovie> findAll();
    UserMovie finaOne(Long id);
    void add(Long id, UserMovieForm userMovie);
    void delete(Long id);
    List<UserMovie> findAllByTitleContaining(String title);
}
