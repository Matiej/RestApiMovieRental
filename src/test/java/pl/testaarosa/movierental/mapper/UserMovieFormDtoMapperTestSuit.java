package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.mapper.form.UserMovieFormDtoMapper;
import pl.testaarosa.movierental.repositories.MockUserMovieForm;
import pl.testaarosa.movierental.repositories.MockUserMovieFormDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UserMovieFormDtoMapperTestSuit {

    private UserMovieFormDtoMapper userMovieFormDtoMapper = new UserMovieFormDtoMapper();
    private MockUserMovieForm mockUserMovieForm = new MockUserMovieForm();
    private List<UserMovieForm> userMovieFormList = new ArrayList<>();
    private MockUserMovieFormDto mockUserMovieFormDto = new MockUserMovieFormDto();
    private List<UserMovieFormDto> userMovieFormDtoList = new ArrayList<>();

    @Before
    public void init() {
        userMovieFormList = mockUserMovieForm.userMovieFormList();
        userMovieFormDtoList = mockUserMovieFormDto.userMovieFormList();
    }

    @Test
    public void testMapToUserMovieForm() {
        //given
        UserMovieFormDto userMovieFormDto = userMovieFormDtoList.get(0);
        UserMovieForm userMovieForm = userMovieFormList.get(0);
        //when
        UserMovieForm userMovieFormResult = userMovieFormDtoMapper.mapToUserMovieForm(userMovieFormDto);
        //then
        assertEquals(userMovieForm, userMovieFormResult);
        assertTrue(userMovieFormResult.getImdbID().equals(userMovieForm.getImdbID()));

    }

    @Test
    public void testMapToUserMovieForm1() {
        //given
        UserMovieFormDto userMovieFormDto = userMovieFormDtoList.get(1);
        UserMovieForm userMovieForm = userMovieFormList.get(1);
        //when
        UserMovieForm userMovieFormResult = userMovieFormDtoMapper.mapToUserMovieForm(userMovieFormDto);
        //then
        assertEquals(userMovieForm, userMovieFormResult);
        assertTrue(userMovieFormResult.getImdbID().equals(userMovieForm.getImdbID()));
    }

    @Test
    public void testMapToUserMovieFormNotTrue() {
        //given
        UserMovieFormDto userMovieFormDto = userMovieFormDtoList.get(0);
        UserMovieForm userMovieForm = userMovieFormList.get(1);
        //when
        UserMovieForm userMovieFormResult = userMovieFormDtoMapper.mapToUserMovieForm(userMovieFormDto);
        //then
        assertNotEquals(userMovieForm, userMovieFormResult);
        assertNotEquals(userMovieFormResult.getImdbID(),userMovieForm.getImdbID());
    }
}
