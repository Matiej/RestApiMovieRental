package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

@RestController
@RequestMapping("/mrapi/blueray")
@Api(description = "Blueray movie rest controller")
public class BlueRayMovieDetailsControllerRest {


    @Autowired
    private MoviesFacade bluRayMoviesFacade;

    @GetMapping("/showmovie")
    @ApiOperation(value = "Find blueray movies by ID", response = BlueRayMovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No blueray movie for given ID"),
            @ApiResponse(code = 200, message = "Blueray movie found"),
            @ApiResponse(code = 400, message = "No blueray movie for given ID")})
    @ApiImplicitParam(required = true, name = "movieId", value = "Enter blueray movie ID",paramType = "query")
    public ResponseEntity<Object> movieDetail(Long movieId) {
        BlueRayMovieDto blueRayMovieDto = null;
        try {
            blueRayMovieDto = bluRayMoviesFacade.findBlueRaById(movieId);
            return ResponseEntity.ok(blueRayMovieDto);
        } catch (MovieNotFoundException movieNotFoundException) {
            movieNotFoundException.printStackTrace();
            return ResponseEntity.status(400).body("Cant find blueray movie for given ID: " + movieId);
        }
    }
}
