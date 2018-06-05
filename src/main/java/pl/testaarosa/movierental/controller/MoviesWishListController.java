package pl.testaarosa.movierental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.mapper.MoviesWishListMapper;
import pl.testaarosa.movierental.services.BlueRayMovieService;
import pl.testaarosa.movierental.services.DvdMovieService;
import pl.testaarosa.movierental.services.MoviesWishListService;
import pl.testaarosa.movierental.services.OnLineMovieService;

@Controller
@RequestMapping("/wish")
public class MoviesWishListController {

    @Autowired
    private MoviesWishListService wishListService;

    @Autowired
    private BlueRayMovieService blueRayService;

    @Autowired
    private MoviesWishListMapper wishListMapper;

    @Autowired
    private DvdMovieService dvdMovieService;

    @Autowired
    private OnLineMovieService onLineMovieService;


    @GetMapping("/bluerayaddwishlist")
    public String addBlueRayToWishList(Model model, @RequestParam Long id){
            BlueRayMovie movie = blueRayService.findbyId(id);
            wishListService.addWish(wishListMapper.mapBlueRayMoviesToWishList(movie));
            model.addAttribute("wishessList", wishListService.findAll());
            return "/templates/moviesWishList";
    }

    @GetMapping("/dvdaddwishlist")
    public String adddvdToWishList(Model model, @RequestParam Long id){
        DvdMovie movie = dvdMovieService.findById(id);
        wishListService.addWish(wishListMapper.mapDvdMoviesToWishList(movie));
        model.addAttribute("wishessList", wishListService.findAll());
        return "/templates/moviesWishList";
    }

    @GetMapping("/onLinAddwishlist")
    public String addOnLineToWishList(Model model, @RequestParam String imdbID){
        OnLineMovieDetails onLineMovieDetails = onLineMovieService.getOnLineMovieDetails(imdbID);
        wishListService.addWish(wishListMapper.mapOnLineMoviesToWishList(onLineMovieDetails));
        model.addAttribute("wishessList", wishListService.findAll());
        return "/templates/moviesWishList";
    }

    @GetMapping("/wishlist")
    public String findAll(Model model){
        model.addAttribute("wishessList", wishListService.findAll());
        return "moviesWishList";
    }

    @GetMapping("/delwish")
    public String delWish(Model model, @RequestParam final Long id){
        wishListService.delWish(id);
        model.addAttribute("wishessList", wishListService.findAll());
        return "moviesWishList";
    }
}
