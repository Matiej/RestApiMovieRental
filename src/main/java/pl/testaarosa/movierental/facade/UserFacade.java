package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.MovieDto;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.mapper.MovieMapper;
import pl.testaarosa.movierental.mapper.MovieWishMapper;
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
    @Autowired
    private MovieWishServiceImpl moviesWishListService;
    @Autowired
    private MovieWishMapper movieWishMapper;
    @Autowired
    private MovieMapper movieMapper;


    public List<UserDto> findAllUsers() {
        return userMapper.userList(userService.findAll());
    }

    public User addUserAndWish(UserFormDto userFormDto) {
        User user = userService.add(userFormDtoMapper.mapToUserForm(userFormDto));
        movieWishService.createMowieWish(user);
        return user;
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

    public UserMovieDto findOneUserMovie(Long id) {
        return userMovieMapper.mapToUserMovieDto(userMovieService.finaOne(id));
    }

    public void deleteUserMovie(Long id) {
        userMovieService.delete(id);
    }

    public MovieWishDto addMovie(String remoteUser, Long id) {
        return movieWishMapper.mapToMovieWishDto(moviesWishListService.addMovieToWish(remoteUser, id));
    }

    public MovieWishDto findUsersWishForGivenUser(String remoteUser) {
        return movieWishMapper.mapToMovieWishDto(moviesWishListService.findUsersWishForGivenUser(remoteUser));
    }

    public List<MovieWishDto> findAllWishes() {
        return movieWishMapper.mapToMovieWishDtoList(moviesWishListService.findAllWishes());
    }

    public MovieWishDto findById(Long id) {
        return movieWishMapper.mapToMovieWishDto(moviesWishListService.findById(id));
    }

    public List<MovieDto> findMoviesForWishByWishId(Long id) {
        MovieWishDto movieWishDto = movieWishMapper.mapToMovieWishDto(moviesWishListService.findById(id));
        return movieMapper.mapTOMovieDtoList(movieWishDto.getMoviesList());
    }
}
