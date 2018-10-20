package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mrapi/usermovie/")
@Api(description = "User movies controller")
public class UserMovieControllerRest {

    @Autowired
    private UserFacade userFacade;


    @GetMapping("movieslist")
    @ApiOperation(value = "Get all remote user own movies. Need to be logged!", response = UserMovieDto.class)
    public List<UserMovieDto> showUserMovies(HttpServletRequest request) {
        return userFacade.findAllUserMoviesForGivenUser(request.getRemoteUser());
    }

    @GetMapping("movieslistsearch")
    @ApiOperation(value = "Search remote user movies by title. Need to be logged!", response = UserMovieDto.class)
    @ApiImplicitParam(required = true, name = "title", value = "movie title", dataType = "string", paramType = "query",
            example = "Indiana Jones for example")
    public List<UserMovieDto> showSearchTitleResult(HttpServletRequest request, String title) {
        return userFacade.findAllUserMoviesByTitleContaining(request.getRemoteUser(), title);
    }

    @ResponseBody
    @PostMapping("addnewmovie")
    @ApiOperation(value = "Add new movie for remote user to the data base. Need to be logged!", response = UserMovieDto.class, ignoreJsonView = true)
    public UserMovieDto addNewMovie(HttpServletRequest request,@RequestBody @Valid UserMovieFormDto userMovieFormDto) {
        return userFacade.addUserMovieRest(request.getRemoteUser(), userMovieFormDto);
    }

    @GetMapping("userMovie")
    @ApiOperation(value = "Find user movie by ID", response = UserMovieDto.class)
    @ApiImplicitParam(required = true, name = "movieId", value = "movie id", paramType = "query")
    public UserMovieDto showMovie(Long movieId) {
        return userFacade.findOneUserMovie(movieId);
    }


    @DeleteMapping("delusermovie")
    @ApiOperation(value = "Delete user movie by given ID", response = UserMovieDto.class)
    @ApiImplicitParam(required = true, name = "movieId", value = "movie id", paramType = "query")
    public UserMovieDto deleteUserMovie(Long movieId) {
        UserMovieDto oneUserMovie = userFacade.findOneUserMovie(movieId);
        userFacade.deleteUserMovie(movieId);
        return oneUserMovie;
    }


}
