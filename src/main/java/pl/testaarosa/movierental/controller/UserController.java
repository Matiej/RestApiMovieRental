package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.mapper.form.UserFormDtoMapper;
import pl.testaarosa.movierental.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserFormDtoMapper mapper;

    @PostMapping("/adduser")
    public String addUser(Model model, @ModelAttribute @Valid UserFormDto userFormDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "userForm";
        } else {
            userService.add(mapper.mapToUserForm(userFormDto));
            List<User> userList = userService.findAll();
            model.addAttribute("users", userList);
            return "userList";
        }
    }

    @GetMapping("/adduser")
    public String showForm(Model model) {
        model.addAttribute("userM", new UserFormDto());
        return "userForm";
    }

}
