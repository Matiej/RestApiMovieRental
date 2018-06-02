package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.services.BlueRayMovieService;

import java.util.Map;

@Controller
@RequestMapping("/two")
//TODO zmienic two na blueray i do tego templatki
public class BlueRayMovieController {
    @Autowired
    private BlueRayMovieService blueRayMovieService;

    @GetMapping("/movieslist")
    public String showMoviesTwoSupplier(Map<String, Object> model){
        model.put("blueRayMoviesFromSuppliers", blueRayMovieService.findAll());
        return "blueRayMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(Model model, @RequestParam String title){
       model.addAttribute("searchresult", blueRayMovieService.findAllContainsTitle(title));
        return "blueRayMovieSearchResult";
    }


}
