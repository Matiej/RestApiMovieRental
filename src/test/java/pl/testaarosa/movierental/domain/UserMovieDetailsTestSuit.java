package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockUserMovieDetails;

import java.util.List;

public class UserMovieDetailsTestSuit {

    private MockUserMovieDetails mockUserMovieDetails = new MockUserMovieDetails();

    @Test
    public void testUserMovieDetails() {
        //given
        List<UserMovieDetails> userMovieDetails = mockUserMovieDetails.userMovieDetails();
        UserMovieDetails userMovieDetails11 = userMovieDetails.get(1);
        UserMovieDetails userMovieDetails12 = userMovieDetails.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(userMovieDetails11, userMovieDetails12).testEquals();

    }
}
