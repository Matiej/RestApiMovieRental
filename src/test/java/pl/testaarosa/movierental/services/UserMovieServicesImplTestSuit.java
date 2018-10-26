package pl.testaarosa.movierental.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.mapper.form.UserMovieFormMapper;
import pl.testaarosa.movierental.repositories.MockUserMovieForm;
import pl.testaarosa.movierental.repositories.MockUserMovie;
import pl.testaarosa.movierental.repositories.UserMovieRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserMovieServicesImplTestSuit {

    private MockUserMovie mockUserMovie = new MockUserMovie();
    private MockUserMovieForm mockUserMovieForm = new MockUserMovieForm();

    @InjectMocks
    private UserMovieServiceImpl userMovieService;

    @Mock
    private UserMovieRepository userMovieRepository;
    @Mock
    private UserMovieFormMapper userMovieFormMapper;
    @Mock
    private UserService userService;

    @Test
    public void testFindAllUsersMoviesForGivenUser() throws MovieNotFoundException {
        //given
        List<UserMovie> expectUserMovieList = mockUserMovie.userMovieList();
        when(userService.findRemoteUser("znikenson@gmail.com")).thenReturn(expectUserMovieList.get(0).getUser());
        when(userMovieRepository.findAllUsersMoviesForGivenUser(1L)).thenReturn(expectUserMovieList);
        //when
        List<UserMovie> result = userMovieService.findAllUsersMoviesForGivenUser("znikenson@gmail.com");
        //then
        assertEquals(expectUserMovieList,result);
        assertEquals(3, result.size());
    }

    @Test
    public void testFinaOne() throws MovieNotFoundException {
        //given
        UserMovie expectUserMovie = mockUserMovie.userMovieList().get(0);
        when(userMovieRepository.findById(null)).thenReturn(expectUserMovie);
        //when
        UserMovie resultUserMovie = userMovieService.finaOne(null);
        //then
        assertEquals(expectUserMovie,resultUserMovie);
    }

    @Test
    public void testAdd() {
        //given
        UserMovie expectUserMovieList = mockUserMovie.userMovieList().get(0);
        when(userService.findRemoteUser("remote1")).thenReturn(expectUserMovieList.getUser());
        List<UserMovieForm> userMovieFormList = mockUserMovieForm.userMovieFormList();
        when(userMovieFormMapper.mapToUserMovie(userMovieFormList.get(0))).thenReturn(expectUserMovieList);
        when(userMovieFormMapper.mapToUserMovieDetails(userMovieFormList.get(0))).thenReturn(expectUserMovieList.getUserMovieDetails());
        when(userMovieRepository.save(expectUserMovieList)).thenReturn(expectUserMovieList);
        //when
        UserMovie resultUserMovie = userMovieService.add("remote1", userMovieFormList.get(0));
        //then
        assertEquals(expectUserMovieList,resultUserMovie);
    }

    @Test
    public void testDelete() {
        //given
        //when
        userMovieRepository.delete(1L);
        //then
        verify(userMovieRepository, times(1)).delete(1L);
        verifyNoMoreInteractions(userMovieRepository);
    }

    @Test
    public void testFindAllUserMoviesByTitleContaining() {
        //given
        User user = mockUserMovie.userMovieList().get(0).getUser();
        when(userService.findRemoteUser("znikenson@gmail.com")).thenReturn(user);
        List<UserMovie> expect = mockUserMovie.userMovieList();
        when(userMovieRepository.findAllUserMoviesByTitleContaining(user.getId(),"My Nice Movie1")).thenReturn(expect);
        //when
        List<UserMovie> result = userMovieService.findAllUserMoviesByTitleContaining("znikenson@gmail.com", "My Nice Movie1");
        //then
        assertEquals(expect,result);
        assertEquals(3, result.size());
    }

}
