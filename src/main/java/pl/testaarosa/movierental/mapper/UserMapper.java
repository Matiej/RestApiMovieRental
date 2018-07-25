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
                        u.getUserDetails(),
                        u.getMovieWishes(),
                        u.getUserMovies(),
                        u.getRole()))
                .collect(Collectors.toList());
    }
}
