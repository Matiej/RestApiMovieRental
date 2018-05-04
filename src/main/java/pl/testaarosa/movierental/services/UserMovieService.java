package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.UserMovie;

import java.util.List;

public interface UserMovieService {
    List<UserMovie> findAll();
    UserMovie finaOne(Long id);
    void add(UserMovie userMovie);
    void delete(Long id);
    List<UserMovie> findAllByTitleContaining(String title);
}
