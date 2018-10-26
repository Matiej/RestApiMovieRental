package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.form.UserMovieForm;

import java.util.List;

public interface UserMovieService {
    List<UserMovie> findAllUsersMoviesForGivenUser(String remoteUser) throws MovieNotFoundException;
    UserMovie finaOne(Long id) throws MovieNotFoundException;
    UserMovie add(String remoteUser, UserMovieForm userMovie);
    void delete(Long id);
    List<UserMovie> findAllUserMoviesByTitleContaining(String remoteUser,String title);
}
