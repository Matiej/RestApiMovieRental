package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockMovie;

import java.util.List;

public class MovieTestSuit {

    private MockMovie mockMovie = new MockMovie();

    @Test
    public void testMovie() {
        //given
        List<Movie> movieList = mockMovie.movieListEqualsTest();
        List<Movie> movieList1 = mockMovie.movieList();
        //then
        //when
        new EqualsTester().addEqualityGroup(movieList,movieList1).testEquals();

    }
}
