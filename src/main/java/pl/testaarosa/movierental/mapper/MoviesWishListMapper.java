package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.*;

@Component
public class MoviesWishListMapper {

    public MoviesWish mapBlueRayMoviesToWishList(BlueRayMovie blueRay) {
        return new MoviesWish(
                blueRay.getImdbID(),
                blueRay.getTitle(),
                blueRay.getBlueRayMovieDetails().getGenre(),
                blueRay.getPoster(),
                "Blue Ray");
    }

//        return MoviesWish.builder()
//                .supId(blueRay.getImdbID())
//                .title(blueRay.getTitle())
//                .filmGenre(blueRay.getBlueRayMovieDetails().getGenre())
//                .poster(blueRay.getPoster())
//                .supplier("Blue Ray")
//                .build();
//    }

    public MoviesWish mapDvdMoviesToWishList(DvdMovie dvd) {
        return new MoviesWish(
                dvd.getImdbID(),
                dvd.getTitle(),
                dvd.getDvdMovieDetails().getType(),
                dvd.getPoster(),
                "Dvd Movie");
    }

    public MoviesWish mapOnLineMoviesToWishList(OnLineMovieDetails dvd) {
        return new MoviesWish(
                dvd.getImdbID(),
                dvd.getTitle(),
                dvd.getGenre(),
                dvd.getPoster(),
                "On Line");
    }
}
