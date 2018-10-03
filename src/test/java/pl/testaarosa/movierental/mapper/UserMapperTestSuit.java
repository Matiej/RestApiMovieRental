package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.repositories.MockUser;
import pl.testaarosa.movierental.repositories.MockUserDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTestSuit {

    @InjectMocks
    private UserMapper userMapper;

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
    public void ShouldMapUserList() {
        //given
        //when
        List<UserDto> result = userMapper.userList(userList);
        //then
        assertEquals(userDtoList,result);
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void ShouldNotMapUserList() {
        //given
        userList.remove(0);
        //when
        List<UserDto> result = userMapper.userList(userList);
        //then
        assertNotEquals(userDtoList,result);
        assertNotNull(result);
        assertNotEquals(userDtoList.size(), result.size());
    }
}
