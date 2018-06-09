package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

import java.util.List;

@Controller
@RequestMapping("/online")
public class OnLineMovieController {

    @Autowired
    private MoviesFacade onLineMovieFacade;

    @RequestMapping("/movielist")
    public String findOnLineMovies(Model model, String title) {
        if (title == null) {
            return "onLineMovieHome";
        } else {
            List<OnLineMovieDto> onLineMovies = onLineMovieFacade.getOnLineMovies(title);
            if (onLineMovies.size() < 1) {
                return "onLineMoviesError";
            } else {
                model.addAttribute("onlinemovieslist", onLineMovies);
                return "onLineMoviesList";
            }
        }
    }

    @RequestMapping("/onlinedetail")
    public String onLineMovieDetail(Model model, String imdbID) {
        OnLineMovieDetailsDto movieDetDto = onLineMovieFacade.getOnLineMovieDetails(imdbID);
        model.addAttribute("onLineMovieDetails", movieDetDto);
        return "onLineMovieDetails";
    }
}
