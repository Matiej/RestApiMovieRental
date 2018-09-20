package pl.testaarosa.movierental.mapper.form;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.repositories.MockUserMovie;
import pl.testaarosa.movierental.repositories.MockUserMovieDetails;
import pl.testaarosa.movierental.repositories.MockUserMovieForm;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserMovieFormMapperTestSuit {

    private MockUserMovie mockUserMovie = new MockUserMovie();
    private List<UserMovie> userMovieList = new ArrayList<>();
    private MockUserMovieDetails mockUserMovieDetails = new MockUserMovieDetails();
    private List<UserMovieDetails> userMovieDetailsList = new ArrayList<>();
    private MockUserMovieForm mockUserMovieForm = new MockUserMovieForm();
    private List<UserMovieForm> userMovieFormList = new ArrayList<>();
    private UserMovieFormMapper userMovieFromMapper = new UserMovieFormMapper();

    @Before
    public void init() {
        userMovieList = mockUserMovie.userMovieList();
        userMovieDetailsList = mockUserMovieDetails.userMovieDetails();
        userMovieFormList = mockUserMovieForm.userMovieFormList();
    }

    @Test
    public void schouldMapToUserMovieCorrect() {
        //given
        UserMovieForm userMovieForm = userMovieFormList.get(0);
        UserMovie userMovie = userMovieList.get(0);
        userMovie.setUserMovieDetails(null);
        userMovie.setUser(null);
        //when
        UserMovie result = userMovieFromMapper.mapToUserMovie(userMovieForm);
        //then
        assertEquals(userMovie, result);
        assertTrue(userMovie.getImdbID().equals(result.getImdbID()));
    }

    @Test
    public void schouldMapToUserMovieNotCorrect() {
        UserMovieForm userMovieForm = userMovieFormList.get(1);
        UserMovie userMovie = userMovieList.get(0);
        userMovie.setUserMovieDetails(null);
        userMovie.setUser(null);
        //when
        UserMovie result = userMovieFromMapper.mapToUserMovie(userMovieForm);
        //then
        assertNotEquals(userMovie, result);
        assertFalse(userMovie.getImdbID().equals(result.getImdbID()));
    }

    @Test
    public void shouldMapToUserMovieDetailsCorrect() {
        //given
        UserMovieForm userMovieForm = userMovieFormList.get(1);
        UserMovieDetails userMovieDetails = userMovieDetailsList.get(1);
        //when
        UserMovieDetails result = userMovieFromMapper.mapToUserMovieDetails(userMovieForm);
        //then
        assertEquals(userMovieDetails, result);
        assertEquals(userMovieDetails.getPoster(), result.getPoster());
    }

    @Test
    public void shouldMapToUserMovieDetailsNotCorrect() {
        UserMovieForm userMovieForm = userMovieFormList.get(0);
        UserMovieDetails userMovieDetails = userMovieDetailsList.get(1);
        //when
        UserMovieDetails result = userMovieFromMapper.mapToUserMovieDetails(userMovieForm);
        //then
        assertNotEquals(userMovieDetails, result);
        assertNotEquals(userMovieDetails.getPoster(), result.getPoster());
    }

}
