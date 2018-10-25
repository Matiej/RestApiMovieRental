package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.TransactionException;
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
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/mrapi/users/")
@Api(description = "User controller")
public class UserControllerRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserFacade userFacade;

    @ResponseBody
    @PostMapping("add")
    @ApiOperation(value = "Add new user to db", response = User.class)
    public User createUserAccount(@RequestBody @Valid UserFormDto userFormDto) {
        return userFacade.addUserAndWish(userFormDto);
    }

    @ResponseBody
    @PutMapping("update")
    @ApiOperation(value = "Update user data", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No remote user found or not user logged in"),
            @ApiResponse(code = 401, message = "Update failed!!"),
            @ApiResponse(code = 200, message = "Remote user updated successful")})
    public ResponseEntity<Object> updateUserAccount(@RequestBody @Valid UpdateUserFormDto updateUserForm, HttpServletRequest request) {
        UserDto remoteUser = null;
        try {
            remoteUser = userFacade.findRemoteUser(request.getRemoteUser());
            return ResponseEntity.ok(userFacade.updateUser(updateUserForm, remoteUser));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No remote user found ->" + remoteUser + " <- or user not logged in!!");
        } catch (TransactionException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Update failed!");
        }
    }

    @GetMapping("allusers")
    @ApiOperation(value = "Find all users in database", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found")})
    public List<UserDto> findAllUsers() {
        return userFacade.findAllUsers();
    }

    @DeleteMapping("delusernbyid")
    @ApiOperation(value = "Delete user from data base by ID", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No user found in data base"),
            @ApiResponse(code = 200, message = "Remote user deleted successful")})
    @ApiImplicitParam(required = true, name = "userId", value = "User ID", paramType = "query")
    public ResponseEntity<Object> deleteUser(Long userId) {
        try {
            UserDto userToDelete = userFacade.findUserById(userId);
            userFacade.deleteUser(userId);
            return ResponseEntity.ok(userToDelete);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No user ID: " + userId + " found in data base");
        }
    }

    //TODO czy zabangla zrobic if że jak null request jest to zwraca komunikat jakiś czy numery błędów odpowiedni komentarz?
    @DeleteMapping("delremonteuser")
    @ApiOperation(value = "Delete remote user from data base by login/email", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No remote user found in data base or not logged in"),
            @ApiResponse(code = 200, message = "User deleted successful")})
    public ResponseEntity<Object> deleteRemoteUser(HttpServletRequest request) {
        UserDto remoteUser = null;
        try {
            remoteUser = userFacade.findRemoteUser(request.getRemoteUser());
            userFacade.deleteUser(remoteUser.getId());
            return ResponseEntity.ok(remoteUser);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No user ->" + remoteUser + "<- found ind data base or not logged in");
        }
    }

    @GetMapping("userById")
    @ApiOperation(value = "Find user from data base by ID", response = UserDto.class)
    @ApiImplicitParam(required = true, name = "userId", value = "userId", paramType = "query")
    public UserDto findUserById(Long userId) {
        return userFacade.findUserById(userId);
    }

    //TODO ifa zrobic lub odpowiedzi dać takie aby pokazał że nie jestes zalogowany, ewentualnie zrobic login lub cos
    @GetMapping("remoteUserDetails")
    @ApiOperation(value = "Get remote user details from data base. Need to be logged", response = UserDto.class)
    public UserDto getRemoteUserDetails(HttpServletRequest request) {
        return userFacade.findRemoteUser(request.getRemoteUser());
    }
}
