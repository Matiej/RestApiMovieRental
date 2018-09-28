package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MockUpdateUserFormDto {

    private final LocalDateTime currentDate = LocalDateTime.now().withSecond(0).withNano(0);

    public List<UpdateUserFormDto> updateUserFormDtoList() {
        LocalDate birth = LocalDate.of(1988, Month.FEBRUARY,11);
        UpdateUserFormDto userForm1 = new UpdateUserFormDto(
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

        UpdateUserFormDto userForm2 = new UpdateUserFormDto(
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

        List<UpdateUserFormDto> userFormList = new ArrayList<>();
        userFormList.add(userForm1);
        userFormList.add(userForm2);
        return userFormList;
    }
}
