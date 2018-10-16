package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UpdateUserFormDto;
import pl.testaarosa.movierental.form.dto.UserFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @Transactional
    @PostMapping("/adduser")
    public String addUser(Model model, @ModelAttribute @Valid UserFormDto userFormDto, BindingResult bindingResult,
                          WebRequest request, Errors errors) {
        User registerUser = new User();

        if (!bindingResult.hasErrors()) {
            registerUser = createUserAccout(userFormDto);
        }
        if (registerUser == null) {
            bindingResult.rejectValue("email", "message.regError", "There is an account with that email address: "
                    + userFormDto.getEmail());
        }
        if (errors.hasGlobalErrors()) {
            bindingResult.rejectValue("password", "message.passError");
            bindingResult.rejectValue("matchingPassword", "message.passError");
        }
        if (bindingResult.hasErrors()) {
            return "userForm";
        } else {
            model.addAttribute("userFormDto", registerUser);
            return "successRegister";
        }
    }

    @GetMapping("/adduser")
    public String showForm(WebRequest request, Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "userForm";
    }

    @PostMapping("/adduser_n")
    public String addUserN(Model model, @ModelAttribute @Valid UserFormDto userFormDto, BindingResult bindingResult,
                           WebRequest request, Errors errors) throws EmailExistsException {
        User registerUser = new User();

        if (!bindingResult.hasErrors()) {
            registerUser = createUserAccout(userFormDto);
        }
        if (registerUser == null) {
            bindingResult.rejectValue("email", "message.regError", "There is an account with that email address: "
                    + userFormDto.getEmail());
        }
        if (errors.hasGlobalErrors()) {
            bindingResult.rejectValue("password", "message.passError");
            bindingResult.rejectValue("matchingPassword", "message.passError");
        }
        if (bindingResult.hasErrors()) {
            return "userForm_n";
        } else {
            model.addAttribute("userFormDto", registerUser);
            return "successRegister";
        }
    }

    private User createUserAccout(UserFormDto userFormDto) {
        User reg = null;
        try {
            reg = userFacade.addUserAndWish(userFormDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return reg;
    }

    @GetMapping("/adduser_n")
    public String showFormN(WebRequest request, Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "userForm_n";
    }

    @GetMapping("/userslist")
    public String showUsers(Map<String, Object> model) {
        model.put("users", userFacade.findAllUsers());
        return "userList";
    }
//
//    @GetMapping("usersearch")
//    public String showSearchUsers(Model model, @RequestParam String surname){
//        model.addAttribute("searchresult", userService.findAllBySurname(surname));
//        return "userMovieSearchResult";
//    }

    @GetMapping(value = "/login")
    public String getLoginView(Model model, HttpServletRequest httpServletRequest) {
        try {
            Object flash = httpServletRequest.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);
            httpServletRequest.getSession().removeAttribute("flash");
        } catch (Exception e) {

        }
        return "login_u";
    }

    @GetMapping(value = "/login_new")
    public String getLoginViewN(Model model, HttpServletRequest httpServletRequest) {
        try {
            Object flash = httpServletRequest.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);
            httpServletRequest.getSession().removeAttribute("flash");
        } catch (Exception e) {

        }
        return "index";
    }

    @GetMapping(value = "/accesdenied")
    public String accesDenied() {
        return "accesdenided";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "logout_";
    }

    @PostMapping("/updateuser")
    public String update(HttpServletRequest request, Model model, @ModelAttribute @Valid UpdateUserFormDto updateUserFormDto,
                         BindingResult bindingResult, Errors errors) {
        boolean emailPass = false;
        String remoteUserEmail = request.getRemoteUser();
        UserDto remoteUser = userFacade.findRemoteUser(remoteUserEmail);
        if (!bindingResult.hasErrors()) {
            emailPass = updateUserAccout(updateUserFormDto, remoteUser);
        }
        if (!emailPass) {
            bindingResult.rejectValue("email", "message.regError", "There is an account with that email address: "
                    + updateUserFormDto.getEmail());
        }
        if (bindingResult.hasErrors()) {
            UpdateUserFormDto remoteUserForUpdate = userFacade.findRemoteUserForUpdate(request.getRemoteUser());
            model.addAttribute("userUpdateInfo", remoteUserForUpdate);
            return "userUpdateForm";
        } else {
            model.addAttribute("updatedRemoteUser", updateUserFormDto);
            model.addAttribute("updatedRemoteUserOldData", remoteUser);
            return "successUpdate";
        }
    }

    private boolean updateUserAccout(UpdateUserFormDto updateUserFormDto, UserDto remoteUser) {
        try {
            userFacade.updateUser(updateUserFormDto, remoteUser);
        } catch (EmailExistsException e) {
            return false;
        }
        return true;
    }

    @GetMapping("/updateuser")
    public String updateShowForm(HttpServletRequest request, Model model) {
        UpdateUserFormDto remoteUserForUpdate = userFacade.findRemoteUserForUpdate(request.getRemoteUser());
        model.addAttribute("userUpdateInfo", remoteUserForUpdate);
        model.addAttribute("updateUserFormDto", remoteUserForUpdate);
        return "userUpdateForm";
    }

    @GetMapping("/details")
    public String userDetails(HttpServletRequest request, Model model) {
        String remoteUser = request.getRemoteUser();
        UserDto remoteUserForUpdate = userFacade.findRemoteUser(remoteUser);
        MovieWishDto wishes = userFacade.findUsersWishForGivenUser(remoteUser);
        List<UserMovieDto> allUserMoviesForGivenUser = userFacade.findAllUserMoviesForGivenUser(remoteUser);
        model.addAttribute("user", remoteUserForUpdate);
        model.addAttribute("userW", wishes);
        model.addAttribute("userM", allUserMoviesForGivenUser);
        return "userDetails";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(HttpServletRequest request, @RequestParam Long id) {
        userFacade.deleteUser(id);
        return "index_n";
    }

}
