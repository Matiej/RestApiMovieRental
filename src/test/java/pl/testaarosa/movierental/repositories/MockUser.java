package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.User;

import java.time.LocalDateTime;
import java.time.Month;

public class MockUser {

    private MockUserDetails mockUserDetails = new MockUserDetails();

    public User mockUser() {
        LocalDateTime userDate = LocalDateTime.of(2018, Month.MARCH,11,11,33,44);
        User mockUser1 = User.builder()
                .name("Maciek")
                .surname("Wójcik")
                .email("znikenson@gmail.com")
                .password("password")
                .matchingpassword("password")
                .registerDate(userDate)
                .enabled(true)
                .userDetails(mockUserDetails.userDetails())
                .build();
        return mockUser1;
    }
}
