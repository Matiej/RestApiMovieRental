package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserDetails;
import pl.testaarosa.movierental.domain.UserGender;

import java.time.LocalDate;
import java.time.Month;

public class MockUserDetails {

    public UserDetails userDetails() {
        LocalDate birth = LocalDate.of(1988, Month.FEBRUARY,11);
        UserDetails testUserDetails = UserDetails.builder()
                .birthday(birth)
                .city("Breslaw")
                .street("Zamkowa")
                .userGender(UserGender.MALE)
                .build();
        return testUserDetails;
    }
}
