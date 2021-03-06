package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.UserDto;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUserDto {

    private MockUserRentalDetails mockUserRentalDetails = new MockUserRentalDetails();
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
                false,
                LocalDateTime.now().withNano(0),
                mockUserRentalDetails.userDetails().get(0),
                new ArrayList<>(),
                new ArrayList<>(),
                role.getRole());

        UserDto mockUser2 = new UserDto(
                2L,
                "Maciek2",
                "Wójcik2",
                "znikenson2@gmail.com",
                "password2",
                "password2",
                false,
                LocalDateTime.now().withNano(0),
                mockUserRentalDetails.userDetails().get(1),
                new ArrayList<>(),
                new ArrayList<>(),
                role.getRole());

        UserDto mockUser2EqualsTest = new UserDto(
                2L,
                "Maciek2",
                "Wójcik2",
                "znikenson2@gmail.com",
                "password2",
                "password2",
                false,
                LocalDateTime.now().withNano(0),
                mockUserRentalDetails.userDetails().get(1),
                new ArrayList<>(),
                new ArrayList<>(),
                role.getRole());

        List<UserDto> userList = new ArrayList<>();
        userList.add(mockUser1);
        userList.add(mockUser2);
        userList.add(mockUser2EqualsTest);
        return userList;
    }
}
