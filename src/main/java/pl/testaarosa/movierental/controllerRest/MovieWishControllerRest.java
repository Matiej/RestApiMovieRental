package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.domain.dto.MovieDto;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.facade.UserFacade;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/mrapi/watchwish")
@Api(description = "User movie wishes controller")
public class MovieWishControllerRest {

    @Autowired
    private MoviesFacade moviesFacade;
    @Autowired
    private UserFacade userFacade;

    @GetMapping("/onlinedetail")
    @ApiOperation(value = "Add movie to wish by ID from data base. Need to be logged in!", response = MovieWishDto.class)
    @ApiImplicitParam(required = true, name = "movieId", value = "movie ID from data base", dataType = "string", paramType = "query")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 200, message = "Movie added to wish successful")})
    public MovieWishDto addMovieToWishList(HttpServletRequest request, Long movieId) {
        String remoteUser = request.getRemoteUser();
        userFacade.addMovie(remoteUser, movieId);
        MovieWishDto usersWishForGivenUser = userFacade.findUsersWishForGivenUser(remoteUser);
        return usersWishForGivenUser;
    }

    @PostMapping("/addonline")
    @ApiOperation(value = "Add onLine movie by ImdbID to wish. First movie is add to data base. Need to be logged in!",
            response = MovieWishDto.class)
    @ApiImplicitParam(required = true, name = "imdbID", value = "movie ID from IMDB", dataType = "string", paramType = "query",
            example = "tt0087469")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 200, message = "OnLin movie added to data base and wish successful")})
    public MovieWishDto addOnlineMovieToWishList(HttpServletRequest request, String imdbID) {
        String remoteUser = request.getRemoteUser();
        OnLineMovieDto onLineMovie = null;
        MovieWishDto usersWishForGivenUser = null;

        try {
            onLineMovie = moviesFacade.addOnLineMovieToDb(imdbID);
            userFacade.addMovie(remoteUser, onLineMovie.getId());
            usersWishForGivenUser = userFacade.findUsersWishForGivenUser(remoteUser);
            return usersWishForGivenUser;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Wrong movie ID: " + imdbID);
        }
        return usersWishForGivenUser;
    }

    @GetMapping("wishlistadmin")
    @ApiOperation(value = "Show all wishes for all users. Option for admin.", response = MovieWishDto.class)
    public List<MovieWishDto> showWishes() {
        return userFacade.findAllWishes();
    }

    @GetMapping("userwishes")
    @ApiOperation(value = "Show all wishes for remote user. Need to be logged in", response = MovieWishDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 200, message = "Remote user found, and show wishes")})
    public MovieWishDto showUserWishes(HttpServletRequest request) {
        String remoteUser = null;
        MovieWishDto wish = null;
        try {
            remoteUser = request.getRemoteUser();
            wish = userFacade.findUsersWishForGivenUser(remoteUser);
        } catch (NoSuchElementException e) {
            throw e;
        }
        return wish;
    }

    @GetMapping("moviedetails")
    @ApiOperation(value = "Show movies for wish ", response = MovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No movie for given ID"),
            @ApiResponse(code = 200, message = "Movie found successful")})
    @ApiImplicitParam(required = true, name = "movieId", value = "movie ID from data base", dataType = "string",
            paramType = "query")
    public Object movieDetails(Long movieId) {
        MovieDto movie = moviesFacade.findMovieById(movieId);
        switch (movie.getSupplier().toLowerCase()) {
            case "bluray supplier":
               return moviesFacade.findBlueRaById(movieId);
            case "on line":
                return moviesFacade.findOnLineById(movieId);
            case "dvd supplier":
                return moviesFacade.findDvdById(movieId);
            default:
                return movie;
        }
    }

}