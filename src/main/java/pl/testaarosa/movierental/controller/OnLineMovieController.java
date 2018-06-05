package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.services.OnLineMovieService;

import java.util.List;

@Controller
@RequestMapping("/online")
public class OnLineMovieController {

    @Autowired
    private OnLineMovieService onLineMovieService;

    @RequestMapping("/movielist")
    public String findOnLineMovies(Model model, String title){
        if(title==null) {
            return "onLineMovieHome";
        } else {
            List<OnLineMovie> onLineMovies = onLineMovieService.getOnLineMovies(title);
            if(onLineMovies.size()<1 || onLineMovies==null) {
                return "onLineMoviesError";
            } else {
                model.addAttribute("onlinemovieslist", onLineMovies);
                return "onLineMoviesList";
            }
        }
    }

    @RequestMapping("/onlinedetail")
    public String onLineMovieDetail(Model model, String imdbID){
        model.addAttribute("onLineMovieDetails", onLineMovieService.getOnLineMovieDetails(imdbID));
        return "onLineMovieDetails";
    }
}
