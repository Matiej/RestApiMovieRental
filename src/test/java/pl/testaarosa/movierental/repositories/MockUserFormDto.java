package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.form.dto.UserFormDto;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUserFormDto {

    public List<UserFormDto> mockFormDtoList() {
        LocalDate birth = LocalDate.of(1988, Month.FEBRUARY,11);
        UserFormDto userForm1 = new UserFormDto(
                "Maciek",
                "Wójcik",
                "znikenson@gmail.com",
                "password",
                "password",
                birth.toString(),
                "Breslaw",
                "Zamkowa",
                UserGender.MALE);

        UserFormDto userForm2 = new UserFormDto(
                "Maciek2",
                "Wójcik2",
                "znikenson@gmail.com2",
                "password2",
                "password2",
                birth.toString(),
                "Breslaw2",
                "Zamkowa2",
                UserGender.NOTSURE);

        List<UserFormDto> userFormList = new ArrayList<>();
        userFormList.add(userForm1);
        userFormList.add(userForm2);
        return userFormList;
    }
}
