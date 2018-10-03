package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.repositories.MockBlueRayMovie;

import java.util.List;

public class BlueRayMovieTestSuit {

    private MockBlueRayMovie mockBlueRayMovie = new MockBlueRayMovie();

    @Test
    public void testBlueRayMovieDto() {
        //given
        List<BlueRayMovie> blueRayMovieList = mockBlueRayMovie.blueRayMovieList();
        BlueRayMovie blueRayMovie1 = blueRayMovieList.get(3);
        BlueRayMovie blueRayMovie2 = blueRayMovieList.get(2);
        //when
        EqualsTester equalsTester = new EqualsTester();
        //then
        equalsTester.addEqualityGroup(blueRayMovie1, blueRayMovie2).testEquals();
    }
}
