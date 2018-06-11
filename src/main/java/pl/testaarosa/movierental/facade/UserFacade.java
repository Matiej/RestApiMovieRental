package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.mapper.UserMapper;
import pl.testaarosa.movierental.mapper.UserMovieMapper;
import pl.testaarosa.movierental.mapper.form.UserFormDtoMapper;
import pl.testaarosa.movierental.mapper.form.UserMovieFormDtoMapper;
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

    public List<UserDto> findAllUsers() {
        return userMapper.userList(userService.findAll());
    }

    public void addUser(UserFormDto userFormDto) {
        userService.add(userFormDtoMapper.mapToUserForm(userFormDto));
    }

    public List<UserMovieDto> findAllUserMovies() {
        return userMovieMapper.mapToUserMovieDtoList(userMovieService.findAll());
    }

    public List<UserMovieDto> findAllUserMoviesByTitleContaining(String title) {
        return userMovieMapper.mapToUserMovieDtoList(userMovieService.findAllByTitleContaining(title));
    }

    public UserMovie addUserMovie(Long id, UserMovieFormDto userMovieFormDto) {
       return userMovieService.add(id, userMovieFormDtoMapper.mapToUserMovieForm(userMovieFormDto));
    }

    public UserMovieDto finaOneUserMovie(Long id) {
        return userMovieMapper.mapToUserMovieDto(userMovieService.finaOne(id));
    }

    public void deleteUserMovie(Long id) {
        userMovieService.delete(id);
    }
}
