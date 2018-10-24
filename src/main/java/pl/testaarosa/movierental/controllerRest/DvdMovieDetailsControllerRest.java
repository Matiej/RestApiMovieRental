package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

@RestController
@RequestMapping("/mrapi/watchwish")
@Api(description = "Dvd movie controller")
public class DvdMovieDetailsControllerRest {

    @Autowired
    private MoviesFacade dvdMoviesFacade;

    @GetMapping("/onlinedetail")
    @ApiOperation(value = "Find dvd movie by id", response = DvdMovieDto.class)
    @ApiImplicitParam(required = true, name = "movieId", value = "Dvd movie ID from data base", paramType = "query")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No movie for given ID"),
            @ApiResponse(code = 200, message = "Dvd movie found"),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 400, message = "No movie for given ID")})
    public ResponseEntity<Object> movieDetail(Long movieId) {
        DvdMovieDto dvdMovieDto = null;
        try {
            dvdMovieDto = dvdMoviesFacade.findDvdById(movieId);
            return ResponseEntity.ok(dvdMovieDto);
        } catch (MovieNotFoundException movieNotFoundException) {
            movieNotFoundException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cant find dvd movie for given ID: " + movieId);
        }
    }
}
