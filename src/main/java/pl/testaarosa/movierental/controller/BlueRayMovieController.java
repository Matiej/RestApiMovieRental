package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.BluRayMoviesFacade;
import pl.testaarosa.movierental.mapper.BlueRayMovieMapper;
import pl.testaarosa.movierental.services.BlueRayMovieService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blueray")
//TODO zmienic two na blueray i do tego templatki
public class BlueRayMovieController {

    @Autowired
    private BluRayMoviesFacade bluRayMoviesFacade;
    @Autowired
    private BlueRayMovieService blueRayMovieService;
    @Autowired
    private BlueRayMovieMapper mapper;

    @GetMapping("/movieslist")
    public String showBlueRayMovies(Map<String, Object> model){
//        model.put("blueRayMoviesFromSuppliers", mapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAll()));
        model.put("blueRayMoviesFromSuppliers", bluRayMoviesFacade.findAll());
        return "blueRayMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(Model model, @RequestParam String title){
//        List<BlueRayMovieDto> movieDtoList = mapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAllContainsTitle(title));
        List<BlueRayMovieDto> movieDtoList = bluRayMoviesFacade.findAllContainsTitle(title);
        model.addAttribute("searchresult", movieDtoList);
        return "blueRayMovieSearchResult";
    }


}
