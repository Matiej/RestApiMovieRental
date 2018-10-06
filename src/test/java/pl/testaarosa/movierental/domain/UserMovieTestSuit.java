package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockUserMovie;

import java.util.List;

public class UserMovieTestSuit {

    private MockUserMovie mockUserMovie = new MockUserMovie();

    @Test
    public void testUserMovie() {
        //given
        List<UserMovie> userMovieList = mockUserMovie.userMovieList();
        UserMovie userMovie1 = userMovieList.get(1);
        UserMovie userMovie2 = userMovieList.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(userMovie1, userMovie2).testEquals();
    }
}
