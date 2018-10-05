package pl.testaarosa.movierental.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.repositories.MockMovieWish;
import pl.testaarosa.movierental.repositories.MockOnLineMovie;
import pl.testaarosa.movierental.repositories.MockUser;
import pl.testaarosa.movierental.repositories.MovieWishRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieWishServiceImplTestSuit {

    private MockMovieWish mockMovieWish = new MockMovieWish();
    private MockUser mockUser = new MockUser();
    private MockOnLineMovie mockOnLineMovie = new MockOnLineMovie();

    @InjectMocks
    private MovieWishServiceImpl movieWishService;

    @Mock
    private MovieWishRepository movieWishRepository;
    @Mock
    private UserService userService;
    @Mock
    private MovieService movieService;

    @Test
    public void testFindAllWishes() {
        //given
        List<MovieWish> movieWishList = mockMovieWish.mockMovieWish();
        when(movieWishRepository.findAll()).thenReturn(movieWishList);
        //when
        List<MovieWish> expect = mockMovieWish.mockMovieWish();
        List<MovieWish> result = movieWishService.findAllWishes();
        //then
        assertEquals(3, result.size());
        assertEquals(expect, result);
    }

    @Test
    public void testFindUsersWishForGivenUser() {
        //given
        MovieWish movieWish = mockMovieWish.mockMovieWish().get(0);
        when(movieWishRepository.findAllUsersWishForGivenUser(1L)).thenReturn(movieWish);
        when(userService.findRemoteUser("znikenson@gmail.com")).thenReturn(movieWish.getUser());
        //when
        MovieWish expect = mockMovieWish.mockMovieWish().get(0);
        MovieWish result = movieWishService.findUsersWishForGivenUser("znikenson@gmail.com");
        //then
        assertEquals(expect, result);
    }

    @Test
    public void testCreateMowieWish() throws ExecutionException, InterruptedException {
        //given
        MovieWish movieWish = mockMovieWish.mockMovieWish().get(0);
        when(movieWishRepository.save(movieWish)).thenReturn(movieWish);
        //when
        User user = mockUser.mockUser().get(0);
        MovieWish result = movieWishService.createMowieWish(user);
        MovieWish expect = mockMovieWish.mockMovieWish().get(0);
        //then
        assertEquals(expect, result);
    }

    @Test
    public void testAddMovieToWish() throws ExecutionException, InterruptedException {
        //given
        User user = mockUser.mockUser().get(1);
        Movie onLineMovie = mockOnLineMovie.onLineMovieList().get().get(1);
        when(userService.findRemoteUser(user.getEmail())).thenReturn(user);
        when(movieService.findById(2L)).thenReturn(onLineMovie);
        MovieWish movieWish = mockMovieWish.mockMovieWish().get(1);
        when(movieWishRepository.findAllUsersWishForGivenUser(2l)).thenReturn(movieWish);
        when(movieWishRepository.save(movieWish)).thenReturn(movieWish);
        //when
        MovieWish result = movieWishService.addMovieToWish(user.getEmail(), 2L);
        //then
        assertEquals(movieWish,result);
    }

    @Test
    public void testFindById() {
        //given
        MovieWish movieWish = mockMovieWish.mockMovieWish().get(0);
        when(movieWishRepository.findOne(null)).thenReturn(movieWish);
        //when
        MovieWish expect = mockMovieWish.mockMovieWish().get(0);
        MovieWish result = movieWishService.findById(null);
        //then
        assertEquals(expect,result);
        assertEquals(expect.getWishName(), result.getWishName());
    }
}
