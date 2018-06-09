package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.facade.MoviesFacade;

@Controller
@RequestMapping("one")
public class DvdMovieDetailsController {

    @Autowired
    private MoviesFacade dvdMoviesFacade;

    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
        model.addAttribute("dvdMovieDetail", dvdMoviesFacade.findDvdById(id));
        return "dvdMovieDetails";
    }
}
