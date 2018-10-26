package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.facade.UserFacade;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/mrapi/dvd")
@Api(description = "Movie wish controller")
public class MovieWishControllerRest {

    @Autowired
    private MoviesFacade moviesFacade;
    @Autowired
    private UserFacade userFacade;

    @PostMapping("/addmovietowish")
    @ApiOperation(value = "Add movie to wish by ID from data base. Need to be logged in!", response = MovieWishDto.class)
    @ApiImplicitParam(required = true, name = "movieId", value = "movie ID from data base", paramType = "query")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No remote user found or not user logged in"),
            @ApiResponse(code = 400, message = "Wrong movie ID"),
            @ApiResponse(code = 200, message = "Movie added wish successful")})
    public ResponseEntity<Object> addMovieToWishList(HttpServletRequest request, Long movieId) {
        String remoteUser = null;
        MovieWishDto usersWishForGivenUser = null;
        try {
            remoteUser = request.getRemoteUser();
            userFacade.addMovie(remoteUser, movieId);
            usersWishForGivenUser = userFacade.findUsersWishForGivenUser(remoteUser);
            return ResponseEntity.ok(usersWishForGivenUser);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Wrong movie ID: " + movieId + ", no movie found");

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No remote user found ->" + remoteUser + "<- or user not logged in!!");
        }
    }

    @PostMapping("/addonline")
    @ApiOperation(value = "Add onLine movie by ImdbID to wish. First movie is add to data base than to wish. Need to be logged in!",
            response = MovieWishDto.class)
    @ApiImplicitParam(required = true, name = "imdbID", value = "movie ID from IMDB", dataType = "string", paramType = "query",
            example = "tt0087469")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No remote user found"),
            @ApiResponse(code = 401, message = "No remote user found or not user logged in"),
            @ApiResponse(code = 400, message = "Wrong movie ID"),
            @ApiResponse(code = 200, message = "OnLin movie added to data base and wish successful")})
    public ResponseEntity<Object> addOnlineMovieToWishList(HttpServletRequest request, String imdbID) {
        String remoteUser = null;
        OnLineMovieDto onLineMovie = null;
        MovieWishDto usersWishForGivenUser = null;

        try {
            remoteUser = request.getRemoteUser();
            onLineMovie = moviesFacade.addOnLineMovieToDb(imdbID);
            userFacade.addMovie(remoteUser, onLineMovie.getId());
            usersWishForGivenUser = userFacade.findUsersWishForGivenUser(remoteUser);
            return ResponseEntity.ok(usersWishForGivenUser);
        } catch (ExecutionException e) {
            e.printStackTrace();
            return ResponseEntity.status(503).body(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(503).body(null);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Wrong movie ID: " + imdbID + " no movie found");
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No remote user found ->" + remoteUser + " <- or user not logged in!!");
        }
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
            @ApiResponse(code = 401, message = "No remote user found or not user logged in"),
            @ApiResponse(code = 200, message = "Remote user found, and show wishes")})
    public ResponseEntity<Object> showUserWishes(HttpServletRequest request) {
        String remoteUser = null;
        try {
            remoteUser = request.getRemoteUser();
            return ResponseEntity.ok(userFacade.findUsersWishForGivenUser(remoteUser));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("No remote user found ->" + remoteUser + " <- or user not logged in!!");
        }
    }

    @GetMapping("moviedetails")
    @ApiOperation(value = "Show movies for wish ", response = MovieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "No movie for given ID"),
            @ApiResponse(code = 400, message = "Wrong movie ID"),
            @ApiResponse(code = 200, message = "Movie found successful")})
    @ApiImplicitParam(required = true, name = "movieId", value = "movie ID from data base", dataType = "string",
            paramType = "query")
    public ResponseEntity<Object> movieDetails(Long movieId) {
        MovieDto movie = null;
        try {
            movie = moviesFacade.findMovieById(movieId);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Wrong movie ID: " + movieId + " no movie found");
        }
        switch (movie.getSupplier().toLowerCase()) {
            case "bluray supplier":
                try {
                    return ResponseEntity.ok(moviesFacade.findBlueRaById(movieId));
                } catch (MovieNotFoundException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(400).body("Wrong blueray movie ID: " + movieId + " no movie found");
                }
            case "on line":
                OnLineMovieDto onLineById = null;
                try {
                    return ResponseEntity.ok(moviesFacade.findOnLineById(movieId));
                } catch (MovieNotFoundException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(400).body("Wrong onLine movie ID: " + movieId + " no movie found");
                }
            case "dvd supplier":
                try {
                    return ResponseEntity.ok(moviesFacade.findDvdById(movieId));
                } catch (MovieNotFoundException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(400).body("Wrong dvd movie ID: " + movieId + " no movie found");
                }
            default:
                return ResponseEntity.ok(movie);
        }
    }

}
