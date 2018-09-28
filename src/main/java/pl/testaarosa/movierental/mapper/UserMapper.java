package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserDto> userList(List<User> userList) {
        return userList.stream()
                .map(u -> new UserDto(
                        u.getId(),
                        u.getName(),
                        u.getSurname(),
                        u.getEmail(),
                        u.getPassword(),
                        u.getMatchingPassword(),
                        u.isEnabled(),
                        u.getRegisterDate(),
                        u.getUserRentalDetails(),
                        u.getMovieWishes(),
                        u.getUserMovies(),
                        u.getRole()))
                .collect(Collectors.toList());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getMatchingPassword(),
                user.isEnabled(),
                user.getRegisterDate(),
                user.getUserRentalDetails(),
                user.getMovieWishes(),
                user.getUserMovies(),
                user.getRole());
    }

    public User mapToUser(UserDto userDto) {
        User mapedUser = User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .matchingpassword(userDto.getPassword())
                .registerDate(userDto.getRegisterDate())
                .userDetails(userDto.getUserRentalDetails())
                .userMovies(userDto.getUserMovies())
                .movieWishes(userDto.getMovieWishes())
                .enabled(userDto.isEnabled())
                .role(userDto.getRole())
                .build();
        mapedUser.setId(userDto.getId());
        return mapedUser;
    }

}
