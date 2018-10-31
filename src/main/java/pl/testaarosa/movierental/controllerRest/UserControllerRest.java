package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private UserFacade userFacade;

    @ResponseBody
    @PostMapping("add")
    @ApiOperation(value = "Add new user to db", response = UserDto.class)
    public UserDto createUserAccount(@RequestBody @Valid UserFormDto userFormDto) {
        return userFacade.addUserAndWish(userFormDto);
    }

    @ResponseBody
    @PutMapping("update")
    @ApiOperation(value = "Update user data", response = UserDto.class)
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

    @GetMapping("userbyid")
    @ApiOperation(value = "Find user from data base by ID", response = UserDto.class)
    @ApiImplicitParam(required = true, name = "userId", value = "User Id in data base", paramType = "query")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No user found"),
            @ApiResponse(code = 401, message = "No  user found in data base"),
            @ApiResponse(code = 200, message = "User found successful")})
    public ResponseEntity<Object> findUserById(Long userId) {
        try {
            return ResponseEntity.ok(userFacade.findUserById(userId));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No user ID: " + userId + " found in data base");
        }
    }

    @GetMapping("remoteUserDetails")
    @ApiOperation(value = "Get remote user details from data base. Need to be logged", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No remote user found in data base or not logged in"),
            @ApiResponse(code = 200, message = "Remote user details got successful")})
    public ResponseEntity<Object> getRemoteUserDetails(HttpServletRequest request) {
        try {
            return ResponseEntity.ok(userFacade.findRemoteUser(request.getRemoteUser()));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No user ->" + request.getRemoteUser() + "<- found ind data base or not logged in");
        }
    }
}
