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
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
        if(!bindingResult.hasErrors()) {
            registerUser = createUserAccout(userFormDto);
        }
        if (registerUser==null) {
            bindingResult.rejectValue("email", "message.regError","There is an account with that email address: "
                    + userFormDto.getEmail());
        }
        if(errors.hasGlobalErrors()) {
            bindingResult.rejectValue("password","message.passError");
            bindingResult.rejectValue("matchingPassword","message.passError");
        }
        if(bindingResult.hasErrors()) {
            return "userForm";
        } else {
            model.addAttribute("userFormDto",registerUser);
            return "successRegister";
        }
    }

    @GetMapping("/adduser")
    public String showForm(WebRequest request, Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "userForm";
    }

    @Transactional
    @PostMapping("/adduser_n")
    public String addUserN(Model model, @ModelAttribute @Valid UserFormDto userFormDto, BindingResult bindingResult,
                           WebRequest request, Errors errors) throws EmailExistsException {
        User registerUser = new User();

        if(!bindingResult.hasErrors()) {
            registerUser = createUserAccout(userFormDto);
        }
        if (registerUser==null) {
            bindingResult.rejectValue("email", "message.regError","There is an account with that email address: "
                    + userFormDto.getEmail());
        }
        if(errors.hasGlobalErrors()) {
            bindingResult.rejectValue("password","message.passError");
            bindingResult.rejectValue("matchingPassword","message.passError");
        }
        if(bindingResult.hasErrors()) {
            return "userForm_n";
        } else {
            model.addAttribute("userFormDto",registerUser);
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginView(Model model, HttpServletRequest httpServletRequest) {
        try {
            Object flash = httpServletRequest.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);
            httpServletRequest.getSession().removeAttribute("flash");
        } catch (Exception e) {

        }
        return "login_u";
    }

    @RequestMapping(value = "/login_new", method = RequestMethod.GET)
    public String getLoginViewN(Model model, HttpServletRequest httpServletRequest) {
        try {
            Object flash = httpServletRequest.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);
            httpServletRequest.getSession().removeAttribute("flash");
        } catch (Exception e) {

        }
        return "index";
    }

    @RequestMapping(value = "/accesdenied", method = RequestMethod.GET)
    public String accesDenied() {
        return "accesdenided";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "logout_";
    }
}
