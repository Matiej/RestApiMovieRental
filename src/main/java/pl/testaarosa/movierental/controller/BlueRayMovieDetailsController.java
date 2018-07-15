package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

@Controller
@RequestMapping("/blueray")
public class BlueRayMovieDetailsController {

    @Autowired
    private MoviesFacade bluRayMoviesFacade;

    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
        BlueRayMovieDto blueRayMovieDto = bluRayMoviesFacade.findbyId(id);
        model.addAttribute("movieDetail", blueRayMovieDto);
        return "blueRayMoviesDetails";
    }
}
