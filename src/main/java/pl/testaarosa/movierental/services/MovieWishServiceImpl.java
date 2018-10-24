package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.repositories.MovieWishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieWishServiceImpl implements MovieWishService {

    @Autowired
    private MovieWishRepository movieWishRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieWishServiceImpl.class);

    @Override
    public List<MovieWish> findAllWishes() {
        return movieWishRepository.findAll();
    }

    @Override
    public MovieWish findUsersWishForGivenUser(String remoteUser) {
        Long id = null;
        if (Optional.ofNullable(remoteUser).isPresent()) {
            id = userService.findRemoteUser(remoteUser).getId();
        } else {
            LOGGER.error("\033[31mNo remote user!! +" + remoteUser + "\033[0m");
            throw new UsernameNotFoundException("No remote user!! +" + remoteUser);
        }
        return movieWishRepository.findAllUsersWishForGivenUser(id);
    }

    @Transactional
    @Override
    public MovieWish createMowieWish(User user) {
        MovieWish movieWish = new MovieWish();
        movieWish.setUser(user);
        movieWish.setWishName(user.getEmail() + ", " + user.getSurname());
        return movieWish;
    }

    @Override
    public MovieWish addMovieToWish(String remoteUser, Long movieId) throws MovieNotFoundException {
        MovieWish one = null;
        Movie movie = null;
        Long remoteUserId = userService.findRemoteUser(remoteUser).getId();
        if (Optional.ofNullable(movieService.findById(movieId)).isPresent()) {
            movie = movieService.findById(movieId);
        } else {
            LOGGER.error("\u001B[31mNo movie found!!\u001B[0m");
            throw new MovieNotFoundException("No movie found");
        }
        one = movieWishRepository.findAllUsersWishForGivenUser(remoteUserId);
        movie.getMovieWishList().add(one);
        one.getMoviesList().add(movie);
        return movieWishRepository.save(one);
    }

    @Override
    public MovieWish findById(Long id) {
        return movieWishRepository.findOne(id);
    }


}
