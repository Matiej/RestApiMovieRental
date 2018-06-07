package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper {

    public List<UserDto> userList(List<User> userList) {
        return userList.stream()
                .map(u -> new UserDto(
                        u.getId(),
                        u.getName(),
                        u.getSurname(),
                        u.getEmail(),
                        u.getRegisterDate(),
                        u.getUserDetails()))
                .collect(Collectors.toList());
    }
}
