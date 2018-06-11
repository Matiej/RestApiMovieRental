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
    public String addBlueRayToWishList(Model model, @RequestParam Long id){
        Movie movie = blueRayService.findbyId(id);
        moviesWishListService.addMovie(movie);
        List<MovieWish> allWishes = moviesWishListService.findAllWishes();
        model.addAttribute("wishes", allWishes);
        return "movieWishList";
    }

    @GetMapping("/wishlist")
    public String showUserMovies(Map<String, Object> model){
        model.put("wishes", moviesWishListService.findAllWishes());
        return "movieWishList";
    }


    @GetMapping("/wishdetails")
    public String wishDetail(Model model, @RequestParam Long id) {
        MovieWish wish = moviesWishListService.findById(id);
        model.addAttribute("wishDetails", wish);
        List<Movie> movieList = wish.getMoviesList();
        model.addAttribute("wishDetailsMovies", movieList);
        return "movieWishDetails";
    }

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
