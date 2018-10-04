package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockDvdMovieDetails;

import java.util.List;

public class DvdMovieDetailsTestSuit {

    private MockDvdMovieDetails mockDvdMovieDetails = new MockDvdMovieDetails();

    @Test
    public void testDvdMovieDetails() {
        //given
        List<DvdMovieDetails> dvdMovieDetailsList = mockDvdMovieDetails.dvdMovieDetailsList();
        DvdMovieDetails dvdMovieDetails1 = dvdMovieDetailsList.get(2);
        DvdMovieDetails dvdMovieDetails2 = dvdMovieDetailsList.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(dvdMovieDetails1,dvdMovieDetails2).testEquals();
    }
}
