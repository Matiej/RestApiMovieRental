package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserDetails;
import pl.testaarosa.movierental.domain.UserGender;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUserDetails {

    public List<UserDetails> userDetails() {
        LocalDate birth = LocalDate.of(1988, Month.FEBRUARY,11);
        UserDetails testUserDetails = UserDetails.builder()
                .birthday(birth)
                .city("Breslaw")
                .street("Zamkowa")
                .userGender(UserGender.MALE)
                .build();

        UserDetails testUserDetails1 = UserDetails.builder()
                .birthday(birth)
                .city("Breslaw2")
                .street("Zamkowa2")
                .userGender(UserGender.NOTSURE)
                .build();

        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(testUserDetails);
        userDetailsList.add(testUserDetails1);
        return userDetailsList;
    }
}
