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
                .supId(dvd.getImdbID())
                .title(dvd.getTitle())
                .filmGenre(dvd.getType())
                .poster(dvd.getPoster())
                .supplier("DVD")
                .build();
    }

    public MoviesWish mapOnLineMoviesToWishList(OnLineMovieDetails online){
        return MoviesWish.builder()
                .supId(online.getImdbID())
                .title(online.getTitle())
                .filmGenre(online.getGenre())
                .poster(online.getPoster())
                .supplier("On Line")
                .build();
    }

}
