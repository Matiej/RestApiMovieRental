package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.MovieWish;

import java.util.ArrayList;
import java.util.List;

public class MockMovieWish {

    private MockUser mockUser = new MockUser();

    public List<MovieWish> mockMovieWish() {

        MovieWish movieWish = new MovieWish();
        movieWish.setUser(mockUser.mockUser());
        movieWish.setWishName("NameWish1");

        List<MovieWish> movieWishList = new ArrayList<>();
        movieWishList.add(movieWish);
        return movieWishList;
    }
}
