package pl.testaarosa.movierental.mapper.form;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserRentalDetails;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.mapper.form.UserFormMapper;
import pl.testaarosa.movierental.repositories.MockUser;
import pl.testaarosa.movierental.repositories.MockUserForm;
import pl.testaarosa.movierental.repositories.MockUserFormDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserFormMapperTestSuit {

    private UserFormMapper userFormMapper = new UserFormMapper();
    private MockUserForm mockuserForm = new MockUserForm();
    private MockUserFormDto mockUserFormDto = new MockUserFormDto();
    private List<UserForm> userFormList = new ArrayList<>();
    private List<UserFormDto> userFormDtoList = new ArrayList<>();
    private MockUser mockUser = new MockUser();

    @Before
    public void init() {
        userFormList = mockuserForm.mockFormList();
        userFormDtoList = mockUserFormDto.mockFormDtoList();
    }

    @Test
    public void testMapToUser() {
        //given
        UserForm userForm = userFormList.get(0);
        User user = mockUser.mockUser().get(0);
        user.setMovieWishes(null);
        user.setId(null);
        user.setUserRentalDetails(null);
        user.setRole(null);
        user.setMovieWishes(new ArrayList<>());
        //when
        User result = userFormMapper.mapToUser(userForm);
        //then
        assertEquals(user,result);
        assertNotNull(result);
        assertTrue(user.getEmail().equals(result.getEmail()));
    }

    @Test
    public void testMapToUserDetails() {
        //given
        UserForm userForm = userFormList.get(1);
        UserRentalDetails userDetails = mockUser.mockUser().get(1).getUserRentalDetails();
        //when
        UserRentalDetails result = userFormMapper.mapToUserDetails(userForm);
        //then
        assertEquals(userDetails,result);
        assertNotNull(result);
        assertTrue(userDetails.getCity().equals(result.getCity()));
        assertTrue(userDetails.getBirthday().equals(result.getBirthday()));
    }
}
