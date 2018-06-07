package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.mapper.UserDtoMapper;
import pl.testaarosa.movierental.mapper.form.UserFormDtoMapper;
import pl.testaarosa.movierental.services.UserService;

import java.util.List;

@Service
public class UserFacade {

    @Autowired
    private UserDtoMapper userDtoMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserFormDtoMapper mapper;

    public List<UserDto> findAll() {
        return userDtoMapper.userList(userService.findAll());
    }

    public void add(UserFormDto userFormDto) {
        userService.add(mapper.mapToUserForm(userFormDto));
    }



}
