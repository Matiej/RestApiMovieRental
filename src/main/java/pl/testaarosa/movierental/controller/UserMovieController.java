package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.services.UserMovieService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserMovieController {
    @Autowired
    private UserMovieService userMovieService;

    @GetMapping("/movieslist")
    public String showUserMovies(Map<String, Object> model){
        model.put("userMovies", userMovieService.findAll());
        return "userMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(Model model, @RequestParam String title){
        model.addAttribute("searchresult", userMovieService.findAllByTitleContaining(title));
        return "userMovieSearchResult";
    }

    @PostMapping("/addnewmovie")
    public String addNewMovie(Model model, @ModelAttribute @Valid UserMovie userMovie,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "userMoviesForm";
        } else {
            userMovieService.add(userMovie);
            List<UserMovie> userMovieList = userMovieService.findAll();
            model.addAttribute("userMovies",userMovieList);
            return "userMoviesList";
        }
    }

    @GetMapping("/addnewmovie")
    public String showForm(Model model){
        model.addAttribute("userMovie", new UserMovie());
        return "userMoviesForm";

    }
    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
        model.addAttribute("userMovieDetail", userMovieService.finaOne(id));
        return "userMovieDetails";
    }

    @GetMapping("/delusermovie")
    public String delUserMovie(Model model, @RequestParam Long id){
        userMovieService.delete(id);
        model.addAttribute("userMovies",userMovieService.findAll());
        return "userMoviesList";
    }
}
