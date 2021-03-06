package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blueray")
public class BlueRayMovieController {

    @Autowired
    private MoviesFacade bluRayMoviesFacade;

    @GetMapping("/movieslist")
    public String showBlueRayMovies(Map<String, Object> model){
        model.put("blueRayMoviesFromSuppliers", bluRayMoviesFacade.findAllBlueRay());
        return "blueRayMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(Model model, @RequestParam String title){
        List<BlueRayMovieDto> movieDtoList = bluRayMoviesFacade.findAllBlueRayContainsTitle(title);
        model.addAttribute("searchresult", movieDtoList);
        return "blueRayMovieSearchResult";
    }


}
