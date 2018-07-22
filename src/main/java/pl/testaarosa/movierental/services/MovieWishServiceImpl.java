package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.repositories.MovieRepository;
import pl.testaarosa.movierental.repositories.MovieWishRepository;

import java.util.List;

@Service
public class MovieWishServiceImpl {

    @Autowired
    private MovieWishRepository movieWishRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;

    public List<MovieWish> findAllWishes() {
        return movieWishRepository.findAll();
    }

    public MovieWish findUsersWishForGivenUser(String remoteUser) {
        Long id = userService.findRemoteUser(remoteUser).getId();
        return movieWishRepository.findAllUsersWishForGivenUser(id);
    }

    public MovieWish createMowieWish(User user) {
        MovieWish movieWish = new MovieWish();
        movieWish.setUser(user);
        movieWish.setWishName(user.getEmail() + ", " + user.getSurname());
        return movieWishRepository.save(movieWish);
    }

    public MovieWish addMovie(String remoteUser, Long movieId) {
        Long remoteUserId = userService.findRemoteUser(remoteUser).getId();
        Movie movie = movieService.findById(movieId);
        MovieWish one = movieWishRepository.findAllUsersWishForGivenUser(remoteUserId);
        one.getMoviesList().add(movie);
        return movieWishRepository.save(one);
    }

    public MovieWish findById(Long id) {
        return movieWishRepository.findOne(id);
    }
}
