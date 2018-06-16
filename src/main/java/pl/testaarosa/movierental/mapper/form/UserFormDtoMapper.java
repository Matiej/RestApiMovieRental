package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;

@Component
public class UserFormDtoMapper {

    public UserForm mapToUserForm(UserFormDto userFormDto) {
        return new UserForm(userFormDto.getName(),
                userFormDto.getSurname(),
                userFormDto.getEmail(),
                userFormDto.getPassword(),
                userFormDto.getRegisterDate(),
                userFormDto.getBrithday(),
                userFormDto.getCity(),
                userFormDto.getStreet(),
                userFormDto.getUserGender());
    }
}



