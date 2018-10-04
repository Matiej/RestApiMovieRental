package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockDvdMovie;

import java.util.List;

public class DvdMovieTestSuit {

    private MockDvdMovie mockDvdMovie = new MockDvdMovie();

    @Test
    public void testDvdMovie() {
        //given
        List<DvdMovie> dvdMovies = mockDvdMovie.dvdMovieList();
        DvdMovie dvdMovie1 = dvdMovies.get(2);
        DvdMovie dvdMovie2 = dvdMovies.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(dvdMovie1,dvdMovie2).testEquals();

    }

}
