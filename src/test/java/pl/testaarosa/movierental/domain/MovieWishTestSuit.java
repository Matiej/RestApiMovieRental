package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockMovieWish;

import java.util.List;

public class MovieWishTestSuit {

    private MockMovieWish mockMovieWish = new MockMovieWish();

    @Test
    public void testMovieWish() {
        //given
        List<MovieWish> movieWishList = mockMovieWish.mockMovieWish();
        MovieWish movieWish1 = movieWishList.get(1);
        MovieWish movieWish2 = movieWishList.get(2);
        //then
        //when
        new EqualsTester().addEqualityGroup(movieWish1,movieWish2).testEquals();
    }
}
