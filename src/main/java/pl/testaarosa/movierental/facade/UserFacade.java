package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.mapper.UserMapper;
import pl.testaarosa.movierental.mapper.UserMovieMapper;
import pl.testaarosa.movierental.mapper.form.UserFormDtoMapper;
import pl.testaarosa.movierental.mapper.form.UserMovieFormDtoMapper;
import pl.testaarosa.movierental.services.MovieWishServiceImpl;
import pl.testaarosa.movierental.services.UserMovieService;
import pl.testaarosa.movierental.services.UserService;

import java.util.List;

@Service
public class UserFacade {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserFormDtoMapper userFormDtoMapper;
    @Autowired
    private UserMovieService userMovieService;
    @Autowired
    private UserMovieFormDtoMapper userMovieFormDtoMapper;
    @Autowired
    private UserMovieMapper userMovieMapper;
    @Autowired
    private MovieWishServiceImpl movieWishService;

    public List<UserDto> findAllUsers() {
        return userMapper.userList(userService.findAll());
    }

    public void addUserAndWish(UserFormDto userFormDto) {
        User user = userService.add(userFormDtoMapper.mapToUserForm(userFormDto));
        movieWishService.createMowieWish(user);
    }

    public List<UserMovieDto> findAllUserMoviesForGivenUser(String remoteUser) {
        return userMovieMapper.mapToUserMovieDtoList(userMovieService.findAllUsersMoviesForGivenUser(remoteUser));
    }

    public List<UserMovieDto> findAllUserMoviesByTitleContaining(String remoteUser, String title) {
        return userMovieMapper.mapToUserMovieDtoList(userMovieService.findAllUserMoviesByTitleContaining(remoteUser, title));
    }

    public UserMovie addUserMovie(String remoteUser, UserMovieFormDto userMovieFormDto) {
       return userMovieService.add(remoteUser, userMovieFormDtoMapper.mapToUserMovieForm(userMovieFormDto));
    }

    public UserMovieDto finaOneUserMovie(Long id) {
        return userMovieMapper.mapToUserMovieDto(userMovieService.finaOne(id));
    }

    public void deleteUserMovie(Long id) {
        userMovieService.delete(id);
    }
}
