package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.mapper.form.UserMovieFormMapper;
import pl.testaarosa.movierental.repositories.UserMovieRepository;

import java.util.List;

@Service
public class UserMovieServiceImpl implements UserMovieService {
    @Autowired
    private UserMovieRepository userMovieRepository;
    @Autowired
    private UserMovieFormMapper userMovieFormMapper;
    @Autowired
    private UserService userService;

    @Override
    public List<UserMovie> findAllUsersMoviesForGivenUser(String remoteUser) {
        User user = userService.findRemoteUser(remoteUser);
        return userMovieRepository.findAllUsersMoviesForGivenUser(user.getId());
    }

    @Override
    public UserMovie finaOne(Long id) {
        return userMovieRepository.findById(id);
    }

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
    public List<UserMovie> findAllUserMoviesByTitleContaining(String remoteUser,String title) {
        User user = userService.findRemoteUser(remoteUser);
        return userMovieRepository.findAllUserMoviesByTitleContaining(user.getId(), title);
    }


}
