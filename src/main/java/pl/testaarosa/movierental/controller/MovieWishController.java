package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.services.BlueRayMovieService;
import pl.testaarosa.movierental.services.MovieWishServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/watchwish")
public class MovieWishController {

    @Autowired
    private BlueRayMovieService blueRayService;
    @Autowired
    private MovieWishServiceImpl moviesWishListService;

    @GetMapping("/addmovie")
    public String addMovieToWishList(HttpServletRequest request, Model model, @RequestParam Long id){
        String remoteUser = request.getRemoteUser();
//        Movie movie = blueRayService.findbyId(id);
        moviesWishListService.addMovie(remoteUser, id);
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
    //TODO tym czasem dla blueRay. Zroić dla każdej grupy.
    @GetMapping("/moviedetails")
    public String movie(Model model, @RequestParam Long id){
        Movie movie = moviesWishListService.findMovieById(id);
        if(movie.getSupplier().toLowerCase().contains("ray")){
            model.addAttribute("movieDetail", blueRayService.findbyId(id));
            return "blueRayMoviesDetails";
        } else {
            return "index";
        }
    }

//    @GetMapping("/moviedetailsb")
//    public String movieb(Model model, @RequestParam Long id){
//            model.addAttribute("movieDetail", blueRayService.findbyId(id));
//            return "blueRayMoviesDetails";
//    }

}
