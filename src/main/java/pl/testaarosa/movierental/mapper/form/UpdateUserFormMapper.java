package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserRentalDetails;
import pl.testaarosa.movierental.form.UpdateUserForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class UpdateUserFormMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final LocalDateTime currentDate = LocalDateTime.now().withNano(0);

    public UpdateUserForm mapToUpdateUserForm(User user) {
        return new UpdateUserForm(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRegisterDate(),
                currentDate,
                user.getUserRentalDetails().getBirthday().toString(),
                "no zip yet",
                user.getUserRentalDetails().getCity(),
                user.getUserRentalDetails().getStreet(),
                user.getUserRentalDetails().getUserGender());
    }

    public UserRentalDetails mapToUserDetails(UpdateUserForm updateUserForm, User remoteUser) {
        UserRentalDetails userRentalDetails = UserRentalDetails.builder()
                .birthday(LocalDate.parse(updateUserForm.getBirthday(), formatter))
                .city(updateUserForm.getCity())
                .street(updateUserForm.getStreet())
                .userGender(updateUserForm.getUserGender())
                .build();
        userRentalDetails.setId(remoteUser.getUserRentalDetails().getId());
        return userRentalDetails;
    }

    public User mapToUser(UpdateUserForm updateUserForm, User remoteUser) {
//TODO zobaczyc czy przepisuja sie w ten sposob filmy i wishes uzytkownika
        User updatedUser = User.builder()
                .name(updateUserForm.getName())
                .surname(updateUserForm.getSurname())
                .email(updateUserForm.getEmail())
                .password(remoteUser.getPassword())
                .matchingpassword(remoteUser.getMatchingPassword())
                .registerDate(remoteUser.getRegisterDate())
                .enabled(remoteUser.isEnabled())
                .movieWishes(remoteUser.getMovieWishes())
                .role(remoteUser.getRole())
                .build();
        updatedUser.setId(remoteUser.getId());
        return updatedUser;
    }
}
