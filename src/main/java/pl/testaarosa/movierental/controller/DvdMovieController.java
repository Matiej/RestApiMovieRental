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

import java.util.Map;

@Controller
@RequestMapping("/one")
public class DvdMovieController {

    @Autowired
    private DvdMoviesFacade dvdMoviesFacade;
    @Autowired
    private DvdMovieService dvdMovieService;
    @Autowired
    private DvdMovieMapper dvdMovieMapper;

    @GetMapping("/movieslist")
    public String showDvdMovies(Map<String, Object> model){
//        model.put("dvdMoviesFromSuppliers", dvdMovieMapper.mapToDvdDtoList(dvdMovieService.findAll()));
        model.put("dvdMoviesFromSuppliers", dvdMoviesFacade.findAll());
        return "dvdMoviesList";
    }

    @GetMapping("/movieslistsearch")
    public String showSearchTitleResult(Model model, @RequestParam String title){
//        model.addAttribute("searchresult", dvdMovieMapper.mapToDvdDtoList(dvdMovieService.findByTitle(title)));
        model.addAttribute("searchresult", dvdMoviesFacade.findByTitle(title));
        return "dvdMovieSearchResult";
    }

}
