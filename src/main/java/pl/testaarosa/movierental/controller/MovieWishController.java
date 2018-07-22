package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.mapper.MovieWishMapper;
import pl.testaarosa.movierental.services.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/watchwish")
public class MovieWishController {

    @Autowired
    private UserFacade movieWishFacade;
    @Autowired
    private MovieService movieService;
    @Autowired
    private MoviesFacade moviesFacade;

    @GetMapping("/addmovie")
    public String addMovieToWishList(HttpServletRequest request, Model model, @RequestParam Long id){
        String remoteUser = request.getRemoteUser();
        movieWishFacade.addMovie(remoteUser,id);
        MovieWishDto allWishes = movieWishFacade.findUsersWishForGivenUser(remoteUser);
        model.addAttribute("userWishes", allWishes);
        return "movieUserWishes";
    }

    @GetMapping("/addonline")
    public String addOnlineMovieToWishList(HttpServletRequest request, Model model, @RequestParam String imdbID) {
        String remoteUser = request.getRemoteUser();
        OnLineMovieDto onLineMovie = null;
        try {
            onLineMovie = moviesFacade.addOnLineMovieToDb(imdbID);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        movieWishFacade.addMovie(remoteUser,onLineMovie.getId());
        MovieWishDto allWishes = movieWishFacade.findUsersWishForGivenUser(remoteUser);
        model.addAttribute("userWishes", allWishes);
        return "movieUserWishes";

    }

    //for admin
    @GetMapping("/wishlistadmin")
    public String showWishes(Map<String, Object> model){
        List<MovieWishDto> allWishes = movieWishFacade.findAllWishes();
        model.put("wishes", allWishes);
        return "movieWishListAdmin";
    }

    @GetMapping("/userwishes")
    public String showUserWishes(HttpServletRequest request, Map<String, Object> model) {
        String remoteUser = request.getRemoteUser();
        MovieWishDto wish = movieWishFacade.findUsersWishForGivenUser(remoteUser);
        model.put("userWishes", wish);
        return "movieUserWishes";
    }

    //for admin
    @GetMapping("/wishdetails")
    public String wishDetail(Model model, @RequestParam Long id) {
        MovieWishDto wish = movieWishFacade.findById(id);
        model.addAttribute("wishDetails", wish);
        //TODO movieDTo machen
        List<Movie> movieList = wish.getMoviesList();
        model.addAttribute( "wishDetailsMovies", movieList);
        return "movieWishDetailsAdmin";
    }

    @GetMapping("/moviedetails")
    public String movie(Model model, @RequestParam Long id){
        //TODO movie DTO machen
        Movie movie = movieService.findById(id);
        switch (movie.getSupplier().toLowerCase()) {
            case "bluray supplier":
                model.addAttribute("movieDetail", moviesFacade.findBlueRaById(id));
                return "blueRayMoviesDetails";
            case "on line":
                model.addAttribute("onLineMovieDetailsDb", moviesFacade.findOnLineById(id));
                return "onLineMovieDetailsDb";
            case "dvd supplier":
                model.addAttribute("dvdMovieDetail", moviesFacade.findDvdById(id));
                return "dvdMovieDetails";
            default:
                return "index";
        }
    }
}
