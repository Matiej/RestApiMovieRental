package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.UserDto;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUserDto {

    private MockUserDetails mockUserDetails = new MockUserDetails();
    private MockRole role = new MockRole();

    public List<UserDto> mockUserDto() {
        LocalDateTime userDate = LocalDateTime.of(2018, Month.MARCH, 11, 11, 33, 44);
        UserDto mockUser1 = new UserDto(
                1L,
                "Maciek",
                "Wójcik",
                "znikenson@gmail.com",
                "password",
                "password",
                true,
                userDate,
                mockUserDetails.userDetails().get(0),
                null,
                null,
                role.getRole());

        UserDto mockUser2 = new UserDto(
                2L,
                "Maciek2",
                "Wójcik2",
                "znikenson2@gmail.com",
                "password2",
                "password2",
                true,
                userDate,
                mockUserDetails.userDetails().get(0),
                null,
                null,
                role.getRole());

        List<UserDto> userList = new ArrayList<>();
        userList.add(mockUser1);
        userList.add(mockUser2);
        return userList;
    }
}
