package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.form.UserMovieForm;

import java.util.List;

public interface UserMovieService {
    List<UserMovie> findAllUsersMoviesForGivenUser(String remoteUser);
    UserMovie finaOne(Long id);
    UserMovie add(String remoteUser, UserMovieForm userMovie);
    void delete(Long id);
    List<UserMovie> findAllByTitleContaining(String title);
}
