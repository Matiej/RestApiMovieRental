package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MockMovieWish {

    private MockUser mockUser = new MockUser();

    public List<MovieWish> mockMovieWish()  {
        MovieWish movieWish = new MovieWish();
        List<User> user = mockUser.mockUser();

        movieWish.setUser(user.get(0));
        movieWish.setWishName(user.get(0).getEmail() + ", " + user.get(0).getSurname());
//        movieWish.getMoviesList().add(new Movie());

        MovieWish movieWish2 = new MovieWish();
        movieWish2.setUser(user.get(1));
        movieWish2.setWishName(user.get(1).getEmail() + ", " + user.get(1).getSurname());
//        movieWish2.getMoviesList().add(new Movie());

        List<MovieWish> movieWishList = new ArrayList<>();
        movieWishList.add(movieWish);
        movieWishList.add(movieWish2);
        return movieWishList;
    }
}
