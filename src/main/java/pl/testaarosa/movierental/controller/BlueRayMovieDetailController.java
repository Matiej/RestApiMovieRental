package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.services.BlueRayMovieService;

@Controller
@RequestMapping("/two")
//TODO zmienieć /two na blueray
public class BlueRayMovieDetailController {
    @Autowired
    private BlueRayMovieService blueRayMovieService;

    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
        model.addAttribute("movieDetail", blueRayMovieService.findbyId(id));
        return "/templates/blueRayMoviesDetails";
    }
}
