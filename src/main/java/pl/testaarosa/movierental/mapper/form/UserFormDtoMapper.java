package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;

import java.time.LocalDateTime;

@Component
public class UserFormDtoMapper {
    public UserForm mapToUserForm(UserFormDto userFormDto) {
        LocalDateTime currentDate = LocalDateTime.now().withNano(0);
        return new UserForm(userFormDto.getName(),
                userFormDto.getSurname(),
                userFormDto.getEmail(),
                userFormDto.getPassword(),
                userFormDto.getMatchingPassword(),
                currentDate,
                userFormDto.getBirthday(),
                userFormDto.getCity(),
                userFormDto.getStreet(),
                userFormDto.getUserGender());
    }
}



