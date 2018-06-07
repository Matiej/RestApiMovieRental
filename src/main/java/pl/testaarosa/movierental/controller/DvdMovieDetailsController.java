package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.facade.DvdMoviesFacade;
import pl.testaarosa.movierental.mapper.DvdMovieMapper;
import pl.testaarosa.movierental.services.DvdMovieService;

@Controller
@RequestMapping("one")
public class DvdMovieDetailsController {

    @Autowired
    private DvdMoviesFacade dvdMoviesFacade;

    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
        model.addAttribute("dvdMovieDetail", dvdMoviesFacade.findById(id));
        return "dvdMovieDetails";
    }
}
