package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockUserRentalDetails;

import java.util.List;

public class UserRentalDetailsTestSuit {

    private MockUserRentalDetails mockUserRentalDetails = new MockUserRentalDetails();

    @Test
    public void testUserRentalDetails() {
        //given
        List<UserRentalDetails> userRentalDetails = mockUserRentalDetails.userDetails();
        UserRentalDetails userRentalDetails1 = userRentalDetails.get(1);
        UserRentalDetails userRentalDetails2 = userRentalDetails.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(userRentalDetails1, userRentalDetails2).testEquals();

    }
}
