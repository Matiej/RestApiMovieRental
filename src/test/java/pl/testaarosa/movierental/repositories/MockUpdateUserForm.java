package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.form.UpdateUserForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUpdateUserForm {

    private final LocalDateTime currentDate = LocalDateTime.now().withSecond(0).withNano(0);

    public List<UpdateUserForm> updateUserFormList() {
        LocalDate birth = LocalDate.of(1988, Month.FEBRUARY, 11);
        UpdateUserForm userForm1 = new UpdateUserForm(
                1L,
                "Maciek",
                "Wójcik",
                "znikenson@gmail.com",
                null,
                currentDate,
                birth.toString(),
                "no zip yet",
                "Breslaw",
                "Zamkowa",
                UserGender.MALE);

        UpdateUserForm userForm2 = new UpdateUserForm(
                2L,
                "Maciek2",
                "Wójcik2",
                "znikenson@gmail.com",
                null,
                currentDate,
                birth.toString(),
                "no zip yet",
                "Breslaw2",
                "Zamkowa2",
                UserGender.NOTSURE);
        List<UpdateUserForm> updateUserFormList = new ArrayList<>();
        updateUserFormList.add(userForm1);
        updateUserFormList.add(userForm2);
        return updateUserFormList;
    }
}
