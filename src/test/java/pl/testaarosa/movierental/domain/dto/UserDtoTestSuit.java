package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockUserDto;

import java.util.List;

public class UserDtoTestSuit {

    private MockUserDto mockUserDto = new MockUserDto();

    @Test
    public void testUserDto() {
        //given
        List<UserDto> userDtos = mockUserDto.mockUserDto();
        UserDto userDto1 = userDtos.get(1);
        UserDto userDto2 = userDtos.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(userDto1,userDto2).testEquals();
    }
}
