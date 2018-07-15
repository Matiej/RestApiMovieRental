package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.services.BlueRayMovieService;
import pl.testaarosa.movierental.services.DvdMovieService;
import pl.testaarosa.movierental.services.MovieWishServiceImpl;
import pl.testaarosa.movierental.services.OnLineMovieService;

import javax.servlet.http.HttpServletRequest;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/watchwish")
public class MovieWishController {

    @Autowired
    private BlueRayMovieService blueRayService;
    @Autowired
    private MovieWishServiceImpl moviesWishListService;
    @Autowired
    private OnLineMovieService onLineMovieService;
    @Autowired
    private DvdMovieService dvdMovieService;

    @GetMapping("/addmovie")
    public String addMovieToWishList(HttpServletRequest request, Model model, @RequestParam Long id){
        String remoteUser = request.getRemoteUser();
        moviesWishListService.addMovie(remoteUser, id);
        MovieWish allWishes = moviesWishListService.findUsersWishForGivenUser(remoteUser);
        model.addAttribute("userWishes", allWishes);
        return "movieUserWishes";
    }

    @GetMapping("/addonline")
    public String addOnlineMovieToWishList(HttpServletRequest request, Model model, @RequestParam String imdbID) {
        String remoteUser = request.getRemoteUser();
        OnLineMovie onLineMovie = onLineMovieService.addOnLineMovieToDb(imdbID);
        moviesWishListService.addMovie(remoteUser,onLineMovie.getId());
        MovieWish allWishes = moviesWishListService.findUsersWishForGivenUser(remoteUser);
        model.addAttribute("userWishes", allWishes);
        return "movieUserWishes";

    }

    //for admin
    @GetMapping("/wishlistadmin")
    public String showWishes(Map<String, Object> model){
        model.put("wishes", moviesWishListService.findAllWishes());
        return "movieWishListAdmin";
    }

    @GetMapping("/userwishes")
    public String showUserWishes(HttpServletRequest request, Map<String, Object> model) {
        String remoteUser = request.getRemoteUser();
        model.put("userWishes", moviesWishListService.findUsersWishForGivenUser(remoteUser));
        return "movieUserWishes";
    }

    //for admin
    @GetMapping("/wishdetails")
    public String wishDetail(Model model, @RequestParam Long id) {
        MovieWish wish = moviesWishListService.findById(id);
        model.addAttribute("wishDetails", wish);
        List<Movie> movieList = wish.getMoviesList();
        model.addAttribute( "wishDetailsMovies", movieList);
        return "movieWishDetailsAdmin";
    }

    @GetMapping("/moviedetails")
    public String movie(Model model, @RequestParam Long id){
        Movie movie = moviesWishListService.findMovieById(id);

        switch (movie.getSupplier().toLowerCase()) {
            case "bluray supplier":
                model.addAttribute("movieDetail", blueRayService.findbyId(id));
                return "blueRayMoviesDetails";
            case "on line":
                model.addAttribute("onLineMovieDetailsDb", onLineMovieService.findById(id));
                return "onLineMovieDetailsDb";
            case "dvd supplier":
                model.addAttribute("dvdMovieDetail", dvdMovieService.findById(id));
                return "dvdMovieDetails";
            default:
                return "index";
        }
    }
}
