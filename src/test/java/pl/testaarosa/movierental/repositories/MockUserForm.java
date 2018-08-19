package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.form.UserForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUserForm {

    public List<UserForm> mockFormList() {
        LocalDateTime userDate = LocalDateTime.of(2018, Month.MARCH,11,11,33,44);
        LocalDate birth = LocalDate.of(1988, Month.FEBRUARY,11);
        UserForm userForm1 = new UserForm(
                "Maciek",
                "Wójcik",
                "znikenson@gmail.com",
                "password",
                "password",
                userDate,
                birth.toString(),
                "Breslaw",
                "Zamkowa",
                UserGender.MALE);

        UserForm userForm2 = new UserForm(
                "Maciek2",
                "Wójcik2",
                "znikenson@gmail.com2",
                "password2",
                "password2",
                userDate,
                birth.toString(),
                "Breslaw2",
                "Zamkowa2",
                UserGender.NOTSURE);

                List<UserForm> userFormList = new ArrayList<>();
                userFormList.add(userForm1);
                userFormList.add(userForm2);
                return userFormList;
    }
}
