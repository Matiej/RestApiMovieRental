package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

@RestController
@RequestMapping("/mrapi/blueray")
@Api(description = "Blueray movie rest controller")
public class BlueRayMovieControllerRest {

    @Autowired
    private MoviesFacade bluRayMoviesFacade;

    @GetMapping("/movieslist")
    @ApiOperation(value = "Show all bluray movies", response = BlueRayMovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No blueray movie found"),
            @ApiResponse(code = 200, message = "Bluray movie found"),
            @ApiResponse(code = 400, message = "No bluray movie found")})
    public ResponseEntity<Object> showBlueRayMovies() {
        return ResponseEntity.ok(bluRayMoviesFacade.findAllBlueRay());
    }

    @GetMapping("/movieslistsearch")
    @ApiOperation(value = "Find blueray movies by title", response = BlueRayMovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No blueray movie found"),
            @ApiResponse(code = 200, message = "Blueray movie found"),
            @ApiResponse(code = 400, message = "No blueray movie found")})
    @ApiImplicitParam(required = true, name = "title", value = "Enter dvd movie title", dataType = "string")
    public ResponseEntity<Object> showSearchTitleResult(String title) {
            return ResponseEntity.ok(bluRayMoviesFacade.findAllBlueRayContainsTitle(title));
    }
}
