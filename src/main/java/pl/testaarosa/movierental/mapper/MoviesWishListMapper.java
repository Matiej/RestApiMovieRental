package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.*;

@Component
public class MoviesWishListMapper {

    public MoviesWish mapBlueRayMoviesToWishList(BlueRayMovie blueRay){
        return MoviesWish.builder()
                .supId(blueRay.getImdbID())
                .title(blueRay.getTitle())
                .filmGenre(blueRay.getBlueRayMovieDetails().getGenre())
                .poster(blueRay.getPoster())
                .supplier("Blue Ray")
                .build();
    }

    public MoviesWish mapDvdMoviesToWishList(DvdMovie dvd){
        return MoviesWish.builder()
                .supId(dvd.getMovieId())
                .title(dvd.getTitle())
                .filmGenre(dvd.getFilmGenre())
                .poster(dvd.getPoster())
                .supplier("DVD")
                .build();
    }

    public MoviesWish mapOnLineMoviesToWishList(OnLineMovieDetails blueRay){
        return MoviesWish.builder()
                .supId(blueRay.getImdbID())
                .title(blueRay.getTitle())
                .filmGenre(blueRay.getGenre())
                .poster(blueRay.getPoster())
                .supplier("On Line")
                .build();
    }

}
