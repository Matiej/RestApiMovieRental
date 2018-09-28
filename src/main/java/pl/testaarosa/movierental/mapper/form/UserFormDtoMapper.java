package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;

@Component
public class UserFormDtoMapper {
    //TODO aby uzyc tego do UpdateUserData to trzeba dorzuic mapowanie ID.
    public UserForm mapToUserForm(UserFormDto userFormDto) {
        return new UserForm(userFormDto.getName(),
                userFormDto.getSurname(),
                userFormDto.getEmail(),
                userFormDto.getPassword(),
                userFormDto.getMatchingPassword(),
                userFormDto.getRegisterDate(),
                userFormDto.getBirthday(),
                userFormDto.getCity(),
                userFormDto.getStreet(),
                userFormDto.getUserGender());
    }

    //TODO test ME
//    public UserFormDto mapToUserFormDto(UserForm userForm) {
//        UserFormDto userFormDto = new UserFormDto(
//                userForm.getName(),
//                userForm.getSurname(),
//                userForm.getEmail(),
//                userForm.getPassword(),
//                userForm.getMatchingPassword(),
//                userForm.getRegisterDate(),
//                userForm.getBirthday(),
//                userForm.getCity(),
//                userForm.getStreet(),
//                userForm.getUserGender());
//        userFormDto.setId(userForm.getId());
//        return userFormDto;
//    }
}



