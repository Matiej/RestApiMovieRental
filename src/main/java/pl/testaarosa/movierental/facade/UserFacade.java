package pl.testaarosa.movierental.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.MovieDto;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.mapper.MovieMapper;
import pl.testaarosa.movierental.mapper.MovieWishMapper;
import pl.testaarosa.movierental.mapper.UserMapper;
import pl.testaarosa.movierental.mapper.UserMovieMapper;
import pl.testaarosa.movierental.mapper.form.UpdateUserFormDtoMapper;
import pl.testaarosa.movierental.mapper.form.UserFormDtoMapper;
import pl.testaarosa.movierental.mapper.form.UserMovieFormDtoMapper;
import pl.testaarosa.movierental.services.MovieWishService;
import pl.testaarosa.movierental.services.UserMovieService;
import pl.testaarosa.movierental.services.UserService;

import java.util.List;

@Service
public class UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacade.class);
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
    private MovieWishService movieWishService;
    @Autowired
    private MovieWishMapper movieWishMapper;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private UpdateUserFormDtoMapper updateUserFormDtoMapper;

    public List<UserDto> findAllUsers() {
        return userMapper.userList(userService.findAll());
    }

    public User addUserAndWish(UserFormDto userFormDto) {
        User user = userService.add(userFormDtoMapper.mapToUserForm(userFormDto));
        return user;
    }

    public User updateUser(UpdateUserFormDto updateUserFormDto, UserDto remoteUser) {
        return userService.update(updateUserFormDtoMapper.mapToUpdateUserForm(updateUserFormDto)
                ,userMapper.mapToUser(remoteUser));
    }

    public UserDto findRemoteUser(String remoteUser) {
        return userMapper.mapToUserDto(userService.findRemoteUser(remoteUser));
    }

    public UpdateUserFormDto findRemoteUserForUpdate(String remoteUser){
        return updateUserFormDtoMapper.mapToUpdateUserFormDto(userService.findRemoteUserForUpdate(remoteUser));
    }

    public List<UserMovieDto> findAllUserMoviesForGivenUser(String remoteUser) {
        return userMovieMapper.mapToUserMovieDtoList(userMovieService.findAllUsersMoviesForGivenUser(remoteUser));
    }

    public List<UserMovieDto> findAllUserMoviesByTitleContaining(String remoteUser, String title) {
        return userMovieMapper.mapToUserMovieDtoList(userMovieService.findAllUserMoviesByTitleContaining(remoteUser, title));
    }

    public UserMovie addUserMovie(String remoteUser, UserMovieFormDto userMovieFormDto) {
       return (userMovieService.add(remoteUser, userMovieFormDtoMapper.mapToUserMovieForm(userMovieFormDto)));
    }

    public UserMovieDto addUserMovieRest(String remoteUser, UserMovieFormDto userMovieFormDto) {
        return userMovieMapper.mapToUserMovieDto(addUserMovie(remoteUser,userMovieFormDto));
    }

    public UserMovieDto findOneUserMovie(Long id) {
        return userMovieMapper.mapToUserMovieDto(userMovieService.finaOne(id));
    }

    public void deleteUserMovie(Long id) {
        userMovieService.delete(id);
    }

    public MovieWishDto addMovie(String remoteUser, Long id) {
        return movieWishMapper.mapToMovieWishDto(movieWishService.addMovieToWish(remoteUser, id));
    }

    public MovieWishDto findUsersWishForGivenUser(String remoteUser) {
        return movieWishMapper.mapToMovieWishDto(movieWishService.findUsersWishForGivenUser(remoteUser));
    }

    public List<MovieWishDto> findAllWishes() {
        return movieWishMapper.mapToMovieWishDtoList(movieWishService.findAllWishes());
    }

    public MovieWishDto findById(Long id) {
        return movieWishMapper.mapToMovieWishDto(movieWishService.findById(id));
    }

    public List<MovieDto> findMoviesForWishByWishId(Long id) {
        MovieWishDto movieWishDto1 = findById(id);
        return movieMapper.mapTOMovieDtoList(movieWishDto1.getMoviesList());
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    //TODO napisać testy
    public UserDto findUserById(Long userId) {
        return userMapper.mapToUserDto(userService.findUserById(userId));
    }
}
