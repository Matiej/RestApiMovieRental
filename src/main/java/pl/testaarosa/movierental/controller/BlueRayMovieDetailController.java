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

@Controller
@RequestMapping("/two")
//TODO zmienieć /two na blueray
public class BlueRayMovieDetailController {

    @Autowired
    private BluRayMoviesFacade bluRayMoviesFacade;
    @Autowired
    private BlueRayMovieService blueRayMovieService;
    @Autowired
    private BlueRayMovieMapper movieDetailsMapper;

    @GetMapping("/showmovie")
    public String movieDetail(Model model, @RequestParam Long id) {
//        BlueRayMovieDto blueRayMovieDto = movieDetailsMapper.mapToBlueRayMovieDto(blueRayMovieService.findbyId(id));
        BlueRayMovieDto blueRayMovieDto = bluRayMoviesFacade.findbyId(id);
        model.addAttribute("movieDetail", blueRayMovieDto);
        return "blueRayMoviesDetails";
    }
}
