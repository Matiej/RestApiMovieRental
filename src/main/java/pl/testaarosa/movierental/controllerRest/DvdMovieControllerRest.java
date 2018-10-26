package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

import java.util.List;

@RestController
@RequestMapping("/mrapi/dvd")
@Api(description = "Dvd movie rest controller")
public class DvdMovieControllerRest {


    @Autowired
    private MoviesFacade dvdMoviesFacade;

    @GetMapping("/movieslist")
    @ApiOperation(value = "Show all dvd movies", response = DvdMovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No dvd movie found"),
            @ApiResponse(code = 200, message = "Dvd movie found"),
            @ApiResponse(code = 400, message = "No dvd movie found")})
    public List<DvdMovieDto> showDvdMovies() {
        return dvdMoviesFacade.findAllDvd();
    }

    @GetMapping("/movieslistsearch")
    @ApiOperation(value = "Find dvd movies by title", response = DvdMovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No dvd movie found"),
            @ApiResponse(code = 200, message = "Dvd movie found"),
            @ApiResponse(code = 400, message = "No dvd movie found")})
    @ApiImplicitParam(required = true, name = "title", value = "Enter dvd movie title", dataType = "string",
            paramType = "query")
    public List<DvdMovieDto> showSearchTitleResult(String title) {
        return dvdMoviesFacade.findDvdByTitle(title);
    }

}
