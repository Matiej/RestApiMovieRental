package pl.testaarosa.movierental.mapper.form;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.repositories.MockUserForm;
import pl.testaarosa.movierental.repositories.MockUserFormDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UserFormDtoMapperTestSuit {

    private UserFormDtoMapper userFormDtoMapper = new UserFormDtoMapper();
    private MockUserForm mockuserForm = new MockUserForm();
    private MockUserFormDto mockUserFormDto = new MockUserFormDto();
    private List<UserForm> userFormList;
    private List<UserFormDto> userFormDtoList;

    @Before
    public void init() {
        userFormList = mockuserForm.mockFormList();
        userFormDtoList = mockUserFormDto.mockFormDtoList();
    }

    @Test
    public void testMapToUserForm1() {
        //given
        UserForm userForm = userFormList.get(0);
        UserFormDto userFormDto = userFormDtoList.get(0);
        //when
        UserForm result = userFormDtoMapper.mapToUserForm(userFormDto);
        result.setRegisterDate(null);
        //then
        assertEquals(userForm, result);
        assertEquals(userForm.getEmail(),result.getEmail());
        assertNotNull(result);
    }

    @Test
    public void testMapToUserForm2() {
        //given
        UserForm userForm = userFormList.get(1);
        UserFormDto userFormDto = userFormDtoList.get(1);
        //when
        UserForm result = userFormDtoMapper.mapToUserForm(userFormDto);
        result.setRegisterDate(null);
        //then
        assertEquals(userForm, result);
        assertEquals(userForm.getEmail(),result.getEmail());
        assertNotNull(result);
    }


}
