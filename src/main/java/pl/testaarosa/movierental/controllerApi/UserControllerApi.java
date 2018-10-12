package pl.testaarosa.movierental.controllerApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserFormDto;

import javax.validation.Valid;

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
}
