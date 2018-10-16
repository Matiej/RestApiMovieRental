package pl.testaarosa.movierental.controllerApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;
import pl.testaarosa.movierental.form.dto.UserFormDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mrapi/users/")
@Api(description = "User controller")
public class UserControllerApi {

    @Autowired
    private UserFacade userFacade;

    @ResponseBody
    @PostMapping("add")
    @ApiOperation(value = "Add new user to db", response = User.class)
    public User createUserAccount(@RequestBody @Valid UserFormDto userFormDto){
        return userFacade.addUserAndWish(userFormDto);
    }

    @ResponseBody
    @PutMapping("update")
    @ApiOperation(value = "Update user data", response = User.class)
    @ApiImplicitParam(required = true, name = "remoteUserEmail", value = "email", dataType = "string", paramType = "query",format = "email",example = "jan@example.com")
    public User updateUserAccount(@RequestBody @Valid UpdateUserFormDto updateUserForm, String remoteUserEmail) {
        UserDto remoteUser = userFacade.findRemoteUser(remoteUserEmail);
        return userFacade.updateUser(updateUserForm,remoteUser);
    }

    @GetMapping("allUsers")
    @ApiOperation(value = "Find all users in database", response = UserDto.class)
    public List<UserDto> findAllUsers() {
        return userFacade.findAllUsers();
    }
}
