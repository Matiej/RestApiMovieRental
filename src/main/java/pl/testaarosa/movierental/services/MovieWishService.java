package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.User;

import java.util.List;

public interface MovieWishService {

    List<MovieWish> findAllWishes();
    MovieWish findUsersWishForGivenUser(String remoteUser);
    MovieWish createMowieWish(User user);
    MovieWish addMovieToWish(String remoteUser, Long movieId) throws MovieNotFoundException;
    MovieWish findById(Long id);
}
