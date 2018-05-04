package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.MoviesWishList;

import java.util.List;

public interface MoviesWishListService {
    List<MoviesWishList> findAll();
    void addWish(MoviesWishList moviesWishList);
    void delWish(Long id);
}
