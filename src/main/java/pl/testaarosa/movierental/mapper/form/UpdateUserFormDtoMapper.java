package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.form.UpdateUserForm;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;

import java.time.LocalDateTime;

@Component
public class UpdateUserFormDtoMapper {

    private final LocalDateTime currentDate = LocalDateTime.now().withSecond(0).withNano(0);

    public UpdateUserFormDto mapToUpdateUserFormDto(UpdateUserForm user) {
        return new UpdateUserFormDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRegisterDate(),
                currentDate,
                user.getBirthday().toString(),
                "no zip yet",
                user.getCity(),
                user.getStreet(),
                user.getUserGender());
    }

    public UpdateUserForm mapToUpdateUserForm(UpdateUserFormDto user) {
        return new UpdateUserForm(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRegisterDate(),
                currentDate,
                user.getBirthday().toString(),
                "no zip yet",
                user.getCity(),
                user.getStreet(),
                user.getUserGender());
    }
}
