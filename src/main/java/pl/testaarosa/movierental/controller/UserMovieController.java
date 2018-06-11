package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.mapper.form.UserMovieFormDtoMapper;
import pl.testaarosa.movierental.services.UserMovieService;
import pl.testaarosa.movierental.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usermovie")
public class UserMovieController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/movieslist")
    public String showUserMovies(Map<String, Object> model){
//        model.put("userMovies", userMovieService.findAll());
        model.put("userMovies", userFacade.findAllUserMovies());
        return "userMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(Model model, @RequestParam String title){
        model.addAttribute("searchresult", userFacade.findAllUserMoviesByTitleContaining(title));
        return "userMoviesSearchResult";
    }

    @PostMapping("/addnewmovie")
    public String addNewMovie(Model model, @ModelAttribute @Valid UserMovieFormDto userMovieFormDto,
                              BindingResult bindingResult,@RequestParam Long userId){
        if(bindingResult.hasErrors()){
            return "userMoviesForm";
        } else {
            userFacade.addUserMovie(userId,userMovieFormDto);
            List<UserMovieDto> userMovieList = userFacade.findAllUserMovies();
            model.addAttribute("userMovies",userMovieList);
            return "userMoviesList";
        }
    }

    @GetMapping("/addnewmovie")
    public String showForm(Model model){
        model.addAttribute("userMovie", new UserMovieFormDto());
        model.addAttribute("usersList", userFacade.findAllUsers());
        return "userMoviesForm";

    }
    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
        model.addAttribute("userMovieDetail", userFacade.finaOneUserMovie(id));
        return "userMovieDetails";
    }

    @GetMapping("/delusermovie")
    public String delUserMovie(Model model, @RequestParam Long id){
        userFacade.deleteUserMovie(id);
        model.addAttribute("userMovies",userFacade.findAllUserMovies());
        return "userMoviesList";
    }
}
