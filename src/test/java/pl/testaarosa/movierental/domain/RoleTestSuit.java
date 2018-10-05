package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockRole;

public class RoleTestSuit {

    private MockRole mockRole = new MockRole();

    @Test
    public void testRole() {
        //given
        Role role1 = mockRole.getRole();
        Role role2 = mockRole.getRoleEqualsTest();
        //when
        //then
        new EqualsTester().addEqualityGroup(role1,role2).testEquals();
    }
}
