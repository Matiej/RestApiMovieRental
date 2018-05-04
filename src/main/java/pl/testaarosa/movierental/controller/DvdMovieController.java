package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.services.DvdMovieService;

import java.util.Map;

@Controller
@RequestMapping("/one")
public class DvdMovieController {
    @Autowired
    private DvdMovieService dvdMovieService;

    @GetMapping("/movieslist")
    public String showMoviesOneSupplier(Map<String, Object> model){
        model.put("dvdMoviesFromSuppliers", dvdMovieService.findAll());
        return "dvdMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(Model model, @RequestParam String title){
        model.addAttribute("searchresult", dvdMovieService.findByTitle(title));
        return "dvdMovieSearchResult";
    }

}
