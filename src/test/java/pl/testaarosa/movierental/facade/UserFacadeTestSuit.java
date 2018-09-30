package pl.testaarosa.movierental.facade;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.mapper.MovieMapper;
import pl.testaarosa.movierental.mapper.MovieWishMapper;
import pl.testaarosa.movierental.mapper.UserMapper;
import pl.testaarosa.movierental.mapper.UserMovieMapper;
import pl.testaarosa.movierental.mapper.form.UpdateUserFormDtoMapper;
import pl.testaarosa.movierental.mapper.form.UserFormDtoMapper;
import pl.testaarosa.movierental.mapper.form.UserMovieFormDtoMapper;
import pl.testaarosa.movierental.repositories.MockUser;
import pl.testaarosa.movierental.repositories.MockUserDto;
import pl.testaarosa.movierental.services.MovieWishService;
import pl.testaarosa.movierental.services.UserMovieService;
import pl.testaarosa.movierental.services.UserService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserFacadeTestSuit {

    @InjectMocks
    private UserFacade userFacade;

    @Mock
    private UserMapper userMapper;
    @Mock
    private UserService userService;
    @Mock
    private UserFormDtoMapper userFormDtoMapper;
    @Mock
    private UserMovieService userMovieService;
    @Mock
    private UserMovieFormDtoMapper userMovieFormDtoMapper;
    @Mock
    private UserMovieMapper userMovieMapper;
    @Mock
    private MovieWishService movieWishService;
    @Mock
    private MovieWishMapper movieWishMapper;
    @Mock
    private MovieMapper movieMapper;
    @Mock
    private UpdateUserFormDtoMapper updateUserFormDtoMapper;

    private MockUser mockUser = new MockUser();
    private List<User> userList;
    private MockUserDto mockUserDto = new MockUserDto();
    private List<UserDto> userDtoList;

    @Before
    public void init() {
        userList = mockUser.mockUser();
        userDtoList = mockUserDto.mockUserDto();
    }

    @Test
    public void testFindAllUsers() {
        //given
        when(userFacade.findAllUsers()).thenReturn(userDtoList);
        //when
        List<UserDto> result = userFacade.findAllUsers();
        //then
        assertEquals(userDtoList, result);
        assertEquals(2, result.size());
        assertEquals(userDtoList.get(0).getEmail(), result.get(0).getEmail());
    }

    
}
