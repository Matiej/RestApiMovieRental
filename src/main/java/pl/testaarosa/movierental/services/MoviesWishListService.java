package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.MoviesWish;

import java.util.List;

public interface MoviesWishListService {
    List<MoviesWish> findAll();
    void addWish(MoviesWish moviesWish);
    void delWish(Long id);
}
