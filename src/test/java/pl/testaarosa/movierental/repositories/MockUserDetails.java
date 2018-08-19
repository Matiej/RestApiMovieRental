package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserRentalDetails;
import pl.testaarosa.movierental.domain.UserGender;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUserDetails {

    public List<UserRentalDetails> userDetails() {
        LocalDate birth = LocalDate.of(1988, Month.FEBRUARY,11);
        UserRentalDetails testUserRentalDetails = UserRentalDetails.builder()
                .birthday(birth)
                .city("Breslaw")
                .street("Zamkowa")
                .userGender(UserGender.MALE)
                .build();

        UserRentalDetails testUserRentalDetails1 = UserRentalDetails.builder()
                .birthday(birth)
                .city("Breslaw2")
                .street("Zamkowa2")
                .userGender(UserGender.NOTSURE)
                .build();

        List<UserRentalDetails> userRentalDetailsList = new ArrayList<>();
        userRentalDetailsList.add(testUserRentalDetails);
        userRentalDetailsList.add(testUserRentalDetails1);
        return userRentalDetailsList;
    }
}
