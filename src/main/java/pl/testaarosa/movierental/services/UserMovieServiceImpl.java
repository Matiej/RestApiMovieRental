package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.mapper.form.UserMovieFormMapper;
import pl.testaarosa.movierental.repositories.UserMovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserMovieServiceImpl implements UserMovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMovieServiceImpl.class);
    @Autowired
    private UserMovieRepository userMovieRepository;
    @Autowired
    private UserMovieFormMapper userMovieFormMapper;
    @Autowired
    private UserService userService;

    @Override
    public List<UserMovie> findAllUsersMoviesForGivenUser(String remoteUser) throws MovieNotFoundException {
        User user = userService.findRemoteUser(remoteUser);
        List<UserMovie> moviesForGivenUser = new ArrayList<>();
        if(Optional.ofNullable(userMovieRepository.findAllUsersMoviesForGivenUser(user.getId())).isPresent()) {
            moviesForGivenUser = userMovieRepository.findAllUsersMoviesForGivenUser(user.getId());
        } else {
            LOGGER.error("\u001B[31mNo movie found!!\u001B[0m");
            throw new MovieNotFoundException("No movie found");
        }
        return moviesForGivenUser;
    }

    @Override
    public UserMovie finaOne(Long id) throws MovieNotFoundException {
        if(Optional.ofNullable(userMovieRepository.findById(id)).isPresent()){
            return userMovieRepository.findById(id);
        } else {
            LOGGER.error("\u001B[31mNo movie found with the ID: " + id +" !!\u001B[0m");
            throw new MovieNotFoundException("No movie found with the ID: " + id + " !!");
        }
    }

    @Transactional
    @Override
    public UserMovie add(String remoteUser, UserMovieForm movieForm) {
        User user = userService.findRemoteUser(remoteUser);
        UserMovie userMovie1 = userMovieFormMapper.mapToUserMovie(movieForm);
        UserMovieDetails details = userMovieFormMapper.mapToUserMovieDetails(movieForm);
        userMovie1.setUserMovieDetails(details);
        userMovie1.setUser(user);
        userMovie1.getUserMovieDetails().setUserMovie(userMovie1);
        return userMovieRepository.save(userMovie1);

    }

    @Override
    public void delete(Long id) {
        userMovieRepository.delete(id);
    }

    @Override
    public List<UserMovie> findAllUserMoviesByTitleContaining(String remoteUser, String title) {
        User user = userService.findRemoteUser(remoteUser);
        return userMovieRepository.findAllUserMoviesByTitleContaining(user.getId(), title);
    }
}
