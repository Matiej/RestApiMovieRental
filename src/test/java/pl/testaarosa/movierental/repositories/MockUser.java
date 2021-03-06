package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class    MockUser {

    private MockUserRentalDetails mockUserRentalDetails = new MockUserRentalDetails();
    private MockRole role = new MockRole();

    public List<User> mockUser() {
        LocalDateTime userDate = LocalDateTime.of(2018, Month.MARCH,11,11,33,44);
        User mockUser1 = User.builder()
                .name("Maciek")
                .surname("Wójcik")
                .email("znikenson@gmail.com")
                .password("password")
                .matchingpassword("password")
                .registerDate(LocalDateTime.now().withNano(0))
                .enabled(false)
                .userDetails(mockUserRentalDetails.userDetails().get(0))
                .build();
        mockUser1.setRole(role.getRole());
        mockUser1.setId(1L);

        User mockUser2 = User.builder()
                .name("Maciek2")
                .surname("Wójcik2")
                .email("znikenson2@gmail.com")
                .password("password2")
                .matchingpassword("password2")
                .registerDate(LocalDateTime.now().withNano(0))
                .enabled(false)
                .userDetails(mockUserRentalDetails.userDetails().get(1))
                .build();
        mockUser2.setRole(role.getRole());
        mockUser2.setId(2L);

        User mockUser2EqualsTest = User.builder()
                .name("Maciek2")
                .surname("Wójcik2")
                .email("znikenson2@gmail.com")
                .password("password2")
                .matchingpassword("password2")
                .registerDate(LocalDateTime.now().withNano(0))
                .enabled(false)
                .userDetails(mockUserRentalDetails.userDetails().get(1))
                .build();
        mockUser2EqualsTest.setRole(role.getRole());
        mockUser2EqualsTest.setId(2L);

        List<User> userList = new ArrayList<>();
        userList.add(mockUser1);
        userList.add(mockUser2);
        userList.add(mockUser2EqualsTest);
        return userList;
    }
}
