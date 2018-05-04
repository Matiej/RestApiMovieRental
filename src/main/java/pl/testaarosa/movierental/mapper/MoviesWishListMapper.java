package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.MoviesWishList;

@Component
public class MoviesWishListMapper {

    public MoviesWishList mapBlueRayMoviesToWishList(BlueRayMovie blueRay){
        return MoviesWishList.builder()
                .supId(blueRay.getImdbID())
                .title(blueRay.getTitle())
                .filmGenre(blueRay.getBlueRayMovieDetails().getGenre())
                .poster(blueRay.getPoster())
                .supplier("Blue Ray")
                .build();
    }

    public MoviesWishList mapDvdMoviesToWishList(DvdMovie dvd){
        return MoviesWishList.builder()
                .supId(dvd.getMovieId())
                .title(dvd.getTitle())
                .filmGenre(dvd.getFilmGenre())
                .poster(dvd.getPoster())
                .supplier("DVD")
                .build();
    }

    public MoviesWishList mapOnLineMoviesToWishList(BlueRayMovieDetails blueRay){
        return MoviesWishList.builder()
                .supId(blueRay.getImdbID())
                .title(blueRay.getTitle())
                .filmGenre(blueRay.getGenre())
                .poster(blueRay.getPoster())
                .supplier("On Line")
                .build();
    }

}
