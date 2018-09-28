package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.form.UpdateUserForm;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;
import pl.testaarosa.movierental.mapper.form.UpdateUserFormDtoMapper;
import pl.testaarosa.movierental.repositories.MockUpdateUserForm;
import pl.testaarosa.movierental.repositories.MockUpdateUserFormDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class UpdateUserFormDtoMapperTestSuit {

    @InjectMocks
    private UpdateUserFormDtoMapper updateUserFormDtoMapper;

    private MockUpdateUserForm mockUpdateUserForm = new MockUpdateUserForm();
    private List<UpdateUserForm> updateUserFormList;
    private MockUpdateUserFormDto mockUpdateUserFormDto = new MockUpdateUserFormDto();
    private List<UpdateUserFormDto> updateUserFormDtoList;

    @Before
    public void init() {
        updateUserFormList = mockUpdateUserForm.updateUserFormList();
        updateUserFormDtoList = mockUpdateUserFormDto.updateUserFormDtoList();
    }

    @Test
    public void shouldMapToUpdateUserFormDto1() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(0);
        UpdateUserForm updateUserForm = updateUserFormList.get(0);
        //when
        UpdateUserFormDto result = updateUserFormDtoMapper.mapToUpdateUserFormDto(updateUserForm);
        //then
        assertEquals(updateUserFormDto,result);
        assertNotNull(result);
    }

    @Test
    public void shouldMapToUpdateUserFormDto2() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(1);
        UpdateUserForm updateUserForm = updateUserFormList.get(1);
        //when
        UpdateUserFormDto result = updateUserFormDtoMapper.mapToUpdateUserFormDto(updateUserForm);
        //then
        assertEquals(updateUserFormDto,result);
        assertNotNull(result);
    }

    @Test
    public void shouldNotMapToUpdateUserFormDto() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(1);
        UpdateUserForm updateUserForm = updateUserFormList.get(1);
        updateUserForm.setCity("Wrong Param");
        //when
        UpdateUserFormDto result = updateUserFormDtoMapper.mapToUpdateUserFormDto(updateUserForm);
        //then
        assertNotEquals(updateUserFormDto,result);
        assertNotNull(result);
    }

    @Test
    public void shouldMapToUpdateUserForm1() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(1);
        UpdateUserForm updateUserForm = updateUserFormList.get(1);
        //when
        UpdateUserForm result = updateUserFormDtoMapper.mapToUpdateUserForm(updateUserFormDto);
        //then
        assertEquals(updateUserForm,result);
        assertNotNull(result);
    }

    @Test
    public void shouldMapToUpdateUserForm2() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(0);
        UpdateUserForm updateUserForm = updateUserFormList.get(0);
        //when
        UpdateUserForm result = updateUserFormDtoMapper.mapToUpdateUserForm(updateUserFormDto);
        //then
        assertEquals(updateUserForm,result);
        assertNotNull(result);
    }

    @Test
    public void shouldNotMapToUpdateUserForm2() {
        //given
        UpdateUserFormDto updateUserFormDto = updateUserFormDtoList.get(0);
        UpdateUserForm updateUserForm = updateUserFormList.get(0);
        updateUserForm.setCity("Wrong Param");
        //when
        UpdateUserForm result = updateUserFormDtoMapper.mapToUpdateUserForm(updateUserFormDto);
        //then
        assertNotEquals(updateUserForm,result);
        assertNotNull(result);
    }


}
