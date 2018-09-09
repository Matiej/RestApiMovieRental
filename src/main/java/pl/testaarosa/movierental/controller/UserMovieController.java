package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usermovie")
public class UserMovieController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/movieslist")
    public String showUserMovies(HttpServletRequest request, Map<String, Object> model){
        String remoteUser = request.getRemoteUser();
        model.put("userMovies", userFacade.findAllUserMoviesForGivenUser(remoteUser));
        return "userMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(HttpServletRequest request, Model model, @RequestParam String title){
        String remoteUser = request.getRemoteUser();
        model.addAttribute("searchresult", userFacade.findAllUserMoviesByTitleContaining(remoteUser,title));
        return "userMoviesSearchResult";
    }

    @PostMapping("/addnewmovie")
    public String addNewMovie(HttpServletRequest request, Model model, @ModelAttribute @Valid UserMovieFormDto userMovieFormDto,
                              BindingResult bindingResult){
        String remoteUser = request.getRemoteUser();
        if(bindingResult.hasErrors()){
            return "userMoviesForm";
        } else {
            userFacade.addUserMovie(remoteUser,userMovieFormDto);
            List<UserMovieDto> userMovieList = userFacade.findAllUserMoviesForGivenUser(remoteUser);
            model.addAttribute("userMovies",userMovieList);
            return "userMoviesList";
        }
    }

    @GetMapping("/addnewmovie")
    public String showForm(Model model){
        model.addAttribute("userMovie", new UserMovieFormDto());
        return "userMoviesForm";

    }
    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
        model.addAttribute("userMovieDetail", userFacade.findOneUserMovie(id));
        return "userMovieDetails";
    }

    @GetMapping("/delusermovie")
    public String delUserMovie(HttpServletRequest request,Model model, @RequestParam Long id){
        String remoteUser = request.getRemoteUser();
        userFacade.deleteUserMovie(id);
        model.addAttribute("userMovies",userFacade.findAllUserMoviesForGivenUser(remoteUser));
        return "userMoviesList";
    }
}
