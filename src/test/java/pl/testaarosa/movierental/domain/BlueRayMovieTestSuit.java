package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockBlueRayMovie;

import java.util.List;

public class BlueRayMovieTestSuit {

    private MockBlueRayMovie mockBlueRayMovie = new MockBlueRayMovie();

    @Test
    public void testBlueRayMovie() {
        //given
        List<BlueRayMovie> blueRayMovies = mockBlueRayMovie.blueRayMovieList();
        BlueRayMovie blueRayMovie1 = blueRayMovies.get(2);
        BlueRayMovie blueRayMovie2 = blueRayMovies.get(3);
        //when
        //then
        new EqualsTester().addEqualityGroup(blueRayMovie1,blueRayMovie2).testEquals();
    }
}
