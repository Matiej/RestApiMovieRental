package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockUser;

import java.util.List;

public class UserTestSuit {

    private MockUser mockUser = new MockUser();

    @Test
    public void testUser() {
        List<User> userList = mockUser.mockUser();
        User user1 = userList.get(2);
        User user2 = userList.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(user1,user2).testEquals();
    }
}
