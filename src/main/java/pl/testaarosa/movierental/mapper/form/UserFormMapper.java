package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserDetails;
import pl.testaarosa.movierental.form.UserForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class UserFormMapper {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final LocalDateTime currentDate = LocalDateTime.now().withNano(0);

    public User mapToUser(UserForm userForm) {
        return new User.UserBuilder()
                .name(userForm.getName())
                .surname(userForm.getSurname())
                .email(userForm.getEmail())
                .registerDate(currentDate)
                .build();
    }

    public UserDetails mapToUserDetails(UserForm userForm){
        LocalDate localDate = LocalDate.parse(userForm.getBrithday(), formatter);
        return new UserDetails.UserDetailsBuilder()
                .birthday(localDate)
                .city(userForm.getCity())
                .street(userForm.getStreet())
                .userGender(userForm.getUserGender())
                .build();
    }

}