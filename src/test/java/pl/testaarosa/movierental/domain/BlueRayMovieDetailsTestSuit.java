package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDetails;

import java.util.List;

public class BlueRayMovieDetailsTestSuit {

    private MockBlueRayMovieDetails mockBlueRayMovieDetails = new MockBlueRayMovieDetails();

    @Test
    public void testBlueRayMovieDetails() {
        List<BlueRayMovieDetails> blueRayMovieDetails = mockBlueRayMovieDetails.blueRayMovieDetails();
        BlueRayMovieDetails blueRayMovieDetails11 = blueRayMovieDetails.get(3);
        BlueRayMovieDetails blueRayMovieDetails12 = blueRayMovieDetails.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(blueRayMovieDetails11,blueRayMovieDetails12).testEquals();
    }
}
