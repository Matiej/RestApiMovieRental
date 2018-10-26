package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserRentalDetails;
import pl.testaarosa.movierental.form.UserForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class UserFormMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final LocalDateTime currentDate = LocalDateTime.now().withNano(0);

    public User mapToUser(UserForm userForm) {
        User user =  User.builder()
                .name(userForm.getName())
                .surname(userForm.getSurname())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .matchingpassword(userForm.getMatchingPassword())
                .registerDate(currentDate)
                .build();
        if(Optional.ofNullable(userForm.getId()).isPresent()) {
            user.setId(userForm.getId());
        }
        return user;
    }

    public UserRentalDetails mapToUserDetails(UserForm userForm) {
        LocalDate localDate = LocalDate.parse(userForm.getBirthday(), formatter);
        return UserRentalDetails.builder()
                .birthday(localDate)
                .city(userForm.getCity())
                .street(userForm.getStreet())
                .userGender(userForm.getUserGender())
                .build();
    }
}
