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
import pl.testaarosa.movierental.domain.dto.UserDto;
import pl.testaarosa.movierental.facade.UserFacade;
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

    //TODO landing page after new user
    @Transactional
    @PostMapping("/adduser")
    public String addUser(Model model, @ModelAttribute @Valid UserFormDto userFormDto, BindingResult bindingResult,
                          WebRequest request, Errors errors) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        } else {
            userFacade.addUserAndWish(userFormDto);
            List<UserDto> userDtos = userFacade.findAllUsers();
            model.addAttribute("users", userDtos);
            return "login_new";
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
                           WebRequest request, Errors errors) {
        if (bindingResult.hasErrors()) {
            return "userForm_n";
        } else {
            userFacade.addUserAndWish(userFormDto);
            List<UserDto> userDtos = userFacade.findAllUsers();
            model.addAttribute("users", userDtos);
            return "login";
        }
    }

    @GetMapping("/adduser_n")
    public String showFormN(WebRequest request, Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "userForm_n";
    }

    @GetMapping("/userslist")
    public String showUserMovies(Map<String, Object> model) {
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
        return "login";
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
        return "redirect:/";
    }
}
