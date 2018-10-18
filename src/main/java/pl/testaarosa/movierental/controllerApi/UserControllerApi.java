package pl.testaarosa.movierental.controllerApi;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.controller.UserController;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;
import pl.testaarosa.movierental.form.dto.UserFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mrapi/users/")
@Api(description = "User controller")
public class UserControllerApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
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

    @DeleteMapping("delUserById")
    @ApiOperation(value = "Delete user from data base by ID", response = UserDto.class)
    @ApiImplicitParam(required = true, name = "userId", value = "userId", dataType = "long", paramType = "query")
    public UserDto deleteUser(Long userId) {
        UserDto userToDelete = userFacade.findUserById(userId);
        userFacade.deleteUser(userId);
        return userToDelete;
    }

    //TODO czy zabangla zrobic if że jak null request jest to zwraca komunikat jakiś czy numery błędów odpowiedni komentarz?
    @DeleteMapping("delRemonteUser")
    @ApiOperation(value = "Delete remote user from data base by login/email", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 200, message = "User deleted successful")})
    public UserDto deleteRemoteUser(HttpServletRequest request) {
        UserDto remoteUser = null;
        try {
            remoteUser = userFacade.findRemoteUser(request.getRemoteUser());
            userFacade.deleteUser(remoteUser.getId());
        } catch (NullPointerException e) {
            LOGGER.error("No remote user found");
            throw new NullPointerException("No remote user found!");
        }
        return remoteUser;
    }

    @GetMapping("userById")
    @ApiOperation(value = "Find user from data base by ID", response = UserDto.class)
    @ApiImplicitParam(required = true, name = "userId", value = "userId", dataType = "long", paramType = "query")
    public UserDto findUserById(Long userId) {
        return userFacade.findUserById(userId);
    }

    //TODO ifa zrobic lub odpowiedzi dać takie aby pokazał że nie jestes zalogowany, ewentualnie zrobic login lub cos
    @GetMapping("remoteUserDetails")
    @ApiOperation(value = "Get remote user details from data base. Need to be logged", response = UserDto.class)
    public UserDto getRemoteUserDetails(HttpServletRequest request) {
        request.
        return userFacade.findRemoteUser(request.getRemoteUser());
    }

}
