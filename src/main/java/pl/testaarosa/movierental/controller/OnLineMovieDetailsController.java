package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/online")
public class OnLineMovieDetailsController {

    @Autowired
    private MoviesFacade onLineMovieFacade;

        @RequestMapping("/onlinedetail")
    public String onLineMovieDetail(Model model, String imdbID) {
        OnLineMovieDetailsDto movieDetDto = null;
        try {
            movieDetDto = onLineMovieFacade.getOnLineMovieDetails(imdbID);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addAttribute("onLineMovieDetails", movieDetDto);
        return "onLineMovieDetails";
    }

    @RequestMapping("/onlinedetail_n")
    public String onLineMovieDetailN(Model model, String imdbID) {
        OnLineMovieDetailsDto movieDetDto = null;
        try {
            movieDetDto = onLineMovieFacade.getOnLineMovieDetails(imdbID);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addAttribute("onLineMovieDetails", movieDetDto);
        return "onLineMovieDetails_n";
    }
}
