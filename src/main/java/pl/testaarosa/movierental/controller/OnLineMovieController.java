package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.testaarosa.movierental.services.OnLineMovieService;

@Controller
@RequestMapping("/online")
public class OnLineMovieController {

    @Autowired
    private OnLineMovieService onLineMovieService;

    @RequestMapping("/movielist")
    public String findOnLineMovies(Model model, String title){
        if(title==null) {
            return "/templates/onLineMovieHome";
        } else if(onLineMovieService.getOnLineMovies(title).size()<1) {
            return "/templates/onLineMoviesError";
        } else {
            model.addAttribute("onlinemovieslist", onLineMovieService.getOnLineMovies(title));
            return "/templates/onLineMoviesList";
        }
    }

    @RequestMapping("/onlinedetail")
    public String onLineMovieDetail(Model model, String imdbID){
        model.addAttribute("onLineMovieDetails", onLineMovieService.getOnLineMovieDetails(imdbID));
        return "/templates/onLineMovieDetails";
    }
}
