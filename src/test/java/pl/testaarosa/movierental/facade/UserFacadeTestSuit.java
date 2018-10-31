package pl.testaarosa.movierental.facade;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.MovieDto;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.form.UserForm;
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
import pl.testaarosa.movierental.repositories.*;
import pl.testaarosa.movierental.services.MovieWishService;
import pl.testaarosa.movierental.services.UserMovieService;
import pl.testaarosa.movierental.services.UserService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserFacadeTestSuit {

    @InjectMocks
    private UserFacade userFacade;

    @Mock
    private UserMapper userMapper;
    @Mock
    private UserService userService;
    @Mock
    private UserFormDtoMapper userFormDtoMapper;
    @Mock
    private UserMovieService userMovieService;
    @Mock
    private UserMovieFormDtoMapper userMovieFormDtoMapper;
    @Mock
    private UserMovieMapper userMovieMapper;
    @Mock
    private MovieWishService movieWishService;
    @Mock
    private MovieWishMapper movieWishMapper;
    @Mock
    private MovieMapper movieMapper;
    @Mock
    private UpdateUserFormDtoMapper updateUserFormDtoMapper;

    private MockUser mockUser = new MockUser();
    private List<User> userList;
    private MockUserDto mockUserDto = new MockUserDto();
    private List<UserDto> userDtoList;
    private MockUserFormDto mockUserFormDto = new MockUserFormDto();
    private List<UserFormDto> userFormDtoList;
    private MockUserForm mockUserForm = new MockUserForm();
    private List<UserForm> userFormList;
    private MockUpdateUserFormDto updateUserFormDto = new MockUpdateUserFormDto();
    private List<UpdateUserFormDto> updateUserFormDtoList;
    private MockUserMovieDto mockUserMovieDto = new MockUserMovieDto();
    private List<UserMovieDto> userMovieDtoList;
    private MockUserMovie mockUserMovie = new MockUserMovie();
    private List<UserMovie> userMovieList;
    private MockUserMovieFormDto mockUserMovieFormDto = new MockUserMovieFormDto();
    private List<UserMovieFormDto> userMovieFormDtoList;
    private MockMovieWishDto mockMovieWishDto = new MockMovieWishDto();
    private List<MovieWishDto> movieWishDtoList;
    private MockMovieDto mockMovieDto = new MockMovieDto();
    private List<MovieDto> movieDtoList;
    private MockMovie mockMovie = new MockMovie();
    private List<Movie> movieList;
    private MockMovieWish mockMovieWish = new MockMovieWish();
    private List<MovieWish> movieWishList;

    @Before
    public void init() {
        userList = mockUser.mockUser();
        userDtoList = mockUserDto.mockUserDto();
        userFormDtoList = mockUserFormDto.mockFormDtoList();
        userFormList = mockUserForm.mockFormList();
        updateUserFormDtoList = updateUserFormDto.updateUserFormDtoList();
        userMovieDtoList = mockUserMovieDto.mockUserMovieList();
        userMovieList = mockUserMovie.userMovieList();
        userMovieDtoList = mockUserMovieDto.mockUserMovieList();
        userMovieFormDtoList = mockUserMovieFormDto.userMovieFormList();
        movieWishDtoList = mockMovieWishDto.mockMovieWishDtos();
        movieDtoList = mockMovieDto.movieDtoList();
        movieList = mockMovie.movieList();
        movieWishList = mockMovieWish.mockMovieWish();
    }

    @Test
    public void testFindAllUsers() {
        //given
        when(userFacade.findAllUsers()).thenReturn(userDtoList);
        //when
        List<UserDto> result = userFacade.findAllUsers();
        //then
        assertEquals(userDtoList, result);
        assertEquals(3, result.size());
        assertEquals(userDtoList.get(0).getEmail(), result.get(0).getEmail());
    }

    @Test
    public void testAddUserAndWish() {
        //given
        UserDto user = mockUserDto.mockUserDto().get(0);
//        User user = mockUser.mockUser().get(0);
        UserFormDto userFormDto = userFormDtoList.get(0);
        when(userFacade.addUserAndWish(userFormDto)).thenReturn(user);
        //when
        UserDto result = userFacade.addUserAndWish(userFormDto);
        //then
        assertEquals(user, result);

    }

    @Test
    public void testUpdateUserSucces() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(0);
        UserDto userDto = userDtoList.get(0);
        UserDto userDto1 = userDtoList.get(1);
        when(userFacade.updateUser(updateUserFormDto, userDto)).thenReturn(userDto1);
        //when
        UserDto result = userFacade.updateUser(updateUserFormDto, userDto);
        //then
        assertEquals(userDto1, result);
        assertNotNull(result);
    }

    @Test
    public void testUpdateUserWrong() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(0);
        UserDto userDto = userDtoList.get(0);
        UserDto userDto1 = userDtoList.get(1);
//        User user = userList.get(0);
        User userwrong = userList.get(1);
        when(userFacade.updateUser(updateUserFormDto, userDto)).thenReturn(userDto1);
        //when
        UserDto result = userFacade.updateUser(updateUserFormDto, userDto);
        //then
        assertNotEquals(userwrong, result);
        assertNotNull(result);
    }

    @Test
    public void testfindRemoteUseSucces() {
        //given
        UserDto userDto = mockUserDto.mockUserDto().get(0);
        when(userFacade.findRemoteUser("user")).thenReturn(userDto);
        //when
        UserDto result = userFacade.findRemoteUser("user");
        //then
        assertNotNull(result);
        assertEquals(userDto, result);
    }

    @Test
    public void testfindRemoteUserWrong() {
        //given
        UserDto userDto = mockUserDto.mockUserDto().get(0);
        UserDto userDtoWrong = mockUserDto.mockUserDto().get(1);
        when(userFacade.findRemoteUser("user")).thenReturn(userDto);
        //when
        UserDto result = userFacade.findRemoteUser("user");
        //then
        assertNotNull(result);
        assertNotEquals(userDtoWrong, result);
    }

    @Test
    public void testFindRemoteUserForUpdateSucces() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(0);
        when(userFacade.findRemoteUserForUpdate("user")).thenReturn(updateUserFormDto);
        //when
        UpdateUserFormDto result = userFacade.findRemoteUserForUpdate("user");
        //then
        assertNotNull(result);
        assertEquals(updateUserFormDto, result);
    }

    @Test
    public void testFindRemoteUserForUpdateWrong() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(0);
        UpdateUserFormDto updateUserFormDtoWrong = updateUserFormDtoList.get(1);
        when(userFacade.findRemoteUserForUpdate("user")).thenReturn(updateUserFormDto);
        //when
        UpdateUserFormDto result = userFacade.findRemoteUserForUpdate("user");
        //then
        assertNotNull(result);
        assertNotEquals(updateUserFormDtoWrong, result);
    }

    @Test
    public void testFindAllUserMoviesForGivenUserSuccess() throws MovieNotFoundException {
        //given
        List<UserMovieDto> userMovieDtoList = this.userMovieDtoList;
        when(userFacade.findAllUserMoviesForGivenUser("user")).thenReturn(userMovieDtoList);
        //when
        List<UserMovieDto> result = userFacade.findAllUserMoviesForGivenUser("user");
        //then
        assertEquals(userMovieDtoList, result);
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void testFindAllUserMoviesForGivenUserWrong() throws MovieNotFoundException {
        //given
        List<UserMovieDto> userMovieDtoList = this.userMovieDtoList;
        List<UserMovieDto> userMovieDtoListWrong = new ArrayList<>();
        userMovieDtoListWrong.addAll(userMovieDtoList);
        userMovieDtoListWrong.remove(0);
        when(userFacade.findAllUserMoviesForGivenUser("user")).thenReturn(userMovieDtoList);
        //when
        List<UserMovieDto> result = userFacade.findAllUserMoviesForGivenUser("user");
        //then
        assertNotEquals(userMovieDtoListWrong, result);
        assertNotNull(result);
    }

    @Test
    public void testFindAllUserMoviesByTitleContainingSuccess() {
        //given
        List<UserMovieDto> userMovieDtoList = this.userMovieDtoList;
        when(userFacade.findAllUserMoviesByTitleContaining("user", "title")).thenReturn(userMovieDtoList);
        //when
        List<UserMovieDto> result = userFacade.findAllUserMoviesByTitleContaining("user", "title");
        //then
        assertNotNull(result);
        assertEquals(userMovieDtoList, result);
        assertEquals(3, result.size());
    }

    @Test
    public void testFindAllUserMoviesByTitleContainingWrong() {
        //given
        List<UserMovieDto> userMovieDtoList = this.userMovieDtoList;
        List<UserMovieDto> userMovieDtoListWrong = new ArrayList<>();
        userMovieDtoListWrong.addAll(userMovieDtoList);
        userMovieDtoListWrong.remove(0);
        when(userFacade.findAllUserMoviesByTitleContaining("user", "title")).thenReturn(userMovieDtoList);
        //when
        List<UserMovieDto> result = userFacade.findAllUserMoviesByTitleContaining("user", "title");
        //then
        assertNotNull(result);
        assertNotEquals(userMovieDtoListWrong, result);
        assertEquals(3, result.size());
    }

    @Test
    public void testAddUserMovieSuccess() {
        //given
        UserMovie userMovie = userMovieList.get(0);
        UserMovieFormDto userMovieFormDto = userMovieFormDtoList.get(0);
        when(userFacade.addUserMovie("user", userMovieFormDto)).thenReturn(userMovie);
        //then
        UserMovie result = userFacade.addUserMovie("user", userMovieFormDto);
        //then
        assertNotNull(result);
        assertEquals(userMovie, result);
    }

    @Test
    public void testAddUserMovieWrong() {
        //given
        UserMovie userMovie = userMovieList.get(0);
        UserMovie userMovieWrong = userMovieList.get(1);
        UserMovieFormDto userMovieFormDto = userMovieFormDtoList.get(0);
        when(userFacade.addUserMovie("user", userMovieFormDto)).thenReturn(userMovie);
        //then
        UserMovie result = userFacade.addUserMovie("user", userMovieFormDto);
        //then
        assertNotNull(result);
        assertNotEquals(userMovieWrong, result);
    }

    @Test
    public void testFindOneUserMovieSuccess() throws MovieNotFoundException {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        when(userFacade.findOneUserMovie(1L)).thenReturn(userMovieDto);
        //when
        UserMovieDto result = userFacade.findOneUserMovie(1L);
        //then
        assertNotNull(result);
        assertEquals(userMovieDto, result);
    }

    @Test
    public void testFindOneUserMovieWrong() throws MovieNotFoundException {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        UserMovieDto userMovieDtoWrong = userMovieDtoList.get(1);
        when(userFacade.findOneUserMovie(1L)).thenReturn(userMovieDto);
        //when
        UserMovieDto result = userFacade.findOneUserMovie(1L);
        //then
        assertNotNull(result);
        assertNotEquals(userMovieDtoWrong, result);
    }

    @Test
    public void testDeleteUserMovie() {
        //given
        //when
        userMovieService.delete(1L);
        //then
        verify(userMovieService, times(1)).delete(1L);
        verifyNoMoreInteractions(userMovieService);
    }

    @Test
    public void testaddMovieSuccess() throws MovieNotFoundException {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        when(userFacade.addMovie("user", 1L)).thenReturn(movieWishDto);
        //when
        MovieWishDto result = userFacade.addMovie("user", 1L);
        //then
        assertNotNull(result);
        assertEquals(movieWishDto, result);
    }

    @Test
    public void testaddMovieWrong() throws MovieNotFoundException {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        MovieWishDto movieWishDtoWrong = movieWishDtoList.get(1);
        when(userFacade.addMovie("user", 1L)).thenReturn(movieWishDto);
        //when
        MovieWishDto result = userFacade.addMovie("user", 1L);
        //then
        assertNotNull(result);
        assertNotEquals(movieWishDtoWrong, result);
    }

    @Test
    public void testFindUsersWishForGivenUserSuccess() {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        when(userFacade.findUsersWishForGivenUser("user")).thenReturn(movieWishDto);
        //when
        MovieWishDto result = userFacade.findUsersWishForGivenUser("user");
        //then
        assertEquals(movieWishDto, result);
        assertNotNull(result);
    }

    @Test
    public void testFindUsersWishForGivenUserwrong() {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        MovieWishDto movieWishDtoWrong = movieWishDtoList.get(1);
        when(userFacade.findUsersWishForGivenUser("user")).thenReturn(movieWishDto);
        //when
        MovieWishDto result = userFacade.findUsersWishForGivenUser("user");
        //then
        assertNotEquals(movieWishDtoWrong, result);
        assertNotNull(result);
    }

    @Test
    public void testFindAllWishesSuccess() {
        //given
        List<MovieWishDto> movieWishDtoList = this.movieWishDtoList;
        when(userFacade.findAllWishes()).thenReturn(movieWishDtoList);
        //when
        List<MovieWishDto> result = userFacade.findAllWishes();
        //then
        assertNotNull(result);
        assertEquals(movieWishDtoList, result);
    }

    @Test
    public void testFindAllWishesWrong() {
        //given
        List<MovieWishDto> movieWishDtoList = this.movieWishDtoList;
        List<MovieWishDto> movieWishDtoListWrong = new LinkedList<>();
        movieWishDtoListWrong.addAll(movieWishDtoList);
        movieWishDtoListWrong.remove(0);
        when(userFacade.findAllWishes()).thenReturn(movieWishDtoList);
        //when
        List<MovieWishDto> result = userFacade.findAllWishes();
        //then
        assertNotNull(result);
        assertNotEquals(movieWishDtoListWrong, result);
    }

    @Test
    public void testFindByIdSuccess() {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        when(userFacade.findById(1L)).thenReturn(movieWishDto);
        //when
        MovieWishDto result = userFacade.findById(1L);
        //then
        assertNotNull(result);
        assertEquals(movieWishDto, result);
    }

    @Test
    public void testFindByIdWrong() {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        MovieWishDto movieWishDtoWrong = movieWishDtoList.get(1);
        when(userFacade.findById(1L)).thenReturn(movieWishDto);
        //when
        MovieWishDto result = userFacade.findById(1L);
        //then
        assertNotNull(result);
        assertNotEquals(movieWishDtoWrong, result);
    }

    @Test
    public void testFindMoviesForWishByWishIdSuccess() {
        when(userFacade.findById(1L)).thenReturn(movieWishDtoList.get(0));
        when(userFacade.findMoviesForWishByWishId((1L))).thenReturn(movieDtoList);
        //when
        List<MovieDto> result = userFacade.findMoviesForWishByWishId(1L);
        //then
        assertNotNull(result);
        assertEquals(movieDtoList, result);
    }

    @Test
    public void testFindMoviesForWishByWishIdWrong() {
        when(userFacade.findById(1L)).thenReturn(movieWishDtoList.get(0));
        when(userFacade.findMoviesForWishByWishId((1L))).thenReturn(movieDtoList);
        List<MovieDto> movieDtoListWrong = new ArrayList<>();
        movieDtoListWrong.addAll(movieDtoList);
        movieDtoListWrong.remove(0);
        //when
        List<MovieDto> result = userFacade.findMoviesForWishByWishId(1L);
        //then
        assertNotNull(result);
        assertNotEquals(movieDtoListWrong, result);
    }

    @Test
    public void deteleUser() {
        //given
        //when
        userService.deleteUser(1L);
        //then
        verify(userService, times(1)).deleteUser(1L);
        verifyNoMoreInteractions(userService);
    }
}
