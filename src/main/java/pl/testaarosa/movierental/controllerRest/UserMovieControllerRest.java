package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/mrapi/usermovie/")
@Api(description = "User movies controller")
public class UserMovieControllerRest {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("movieslist")
    @ApiOperation(value = "Get all remote user own movies. Need to be logged!", response = UserMovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No remote user found in data base or not logged in"),
            @ApiResponse(code = 400, message = "No movies found!"),
            @ApiResponse(code = 200, message = "Found user movies")})
    public ResponseEntity<Object> showUserMovies(HttpServletRequest request) {
        try {
            return ResponseEntity.ok(userFacade.findAllUserMoviesForGivenUser(request.getRemoteUser()));
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("No movies for remote user found");
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No remote user found ->" + request.getRemoteUser() + " <- or user not logged in!!");
        }
    }

    @GetMapping("movieslistsearch")
    @ApiOperation(value = "Search remote user movies by title. Need to be logged!", response = UserMovieDto.class)
    @ApiImplicitParam(required = true, name = "title", value = "movie title", dataType = "string", paramType = "query",
            example = "Indiana Jones for example")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No remote user found in data base or not logged in"),
            @ApiResponse(code = 200, message = "Found user movies")})
    public ResponseEntity<Object> showSearchTitleResult(HttpServletRequest request, String title) {
        try {
            return ResponseEntity.ok(userFacade.findAllUserMoviesByTitleContaining(request.getRemoteUser(), title));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No remote user found ->" + request.getRemoteUser() + " <- or user not logged in!!");
        }
    }

    @ResponseBody
    @PostMapping("addnewmovie")
    @ApiOperation(value = "Add new movie for remote user to the data base. Need to be logged!", response = UserMovieDto.class, ignoreJsonView = true)
    public UserMovieDto addNewMovie(HttpServletRequest request, @RequestBody @Valid UserMovieFormDto userMovieFormDto) {
        return userFacade.addUserMovieRest(request.getRemoteUser(), userMovieFormDto);
    }

    @GetMapping("userMovie")
    @ApiOperation(value = "Find user movie by ID", response = UserMovieDto.class)
    @ApiImplicitParam(required = true, name = "movieId", value = "movie id", paramType = "query")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No movie found"),
            @ApiResponse(code = 400, message = "Movie not found for given ID"),
            @ApiResponse(code = 200, message = "Movie found")})
    public ResponseEntity<Object> showMovie(Long movieId) {
        try {
            return ResponseEntity.ok(userFacade.findOneUserMovie(movieId));
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("No movies found with ID: " + movieId);
        }
    }


    @DeleteMapping("delusermovie")
    @ApiOperation(value = "Delete user movie by given ID", response = UserMovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No movie found"),
            @ApiResponse(code = 400, message = "Movie not found for given ID"),
            @ApiResponse(code = 200, message = "Movie deleted successful")})
    @ApiImplicitParam(required = true, name = "movieId", value = "Movie Id in data base", paramType = "query")
    public ResponseEntity<Object> deleteUserMovie(Long movieId) {

        try {
            UserMovieDto oneUserMovie = userFacade.findOneUserMovie(movieId);
            userFacade.deleteUserMovie(movieId);
            return ResponseEntity.ok(oneUserMovie);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("No movies found with ID: " + movieId);
        }
    }
}
