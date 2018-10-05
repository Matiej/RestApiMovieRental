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

        MovieWish movieWish2 = new MovieWish();
        movieWish2.setUser(user.get(1));
        movieWish2.setWishName(user.get(1).getEmail() + ", " + user.get(1).getSurname());

        MovieWish movieWish2EqualsTest = new MovieWish();
        movieWish2EqualsTest.setUser(user.get(1));
        movieWish2EqualsTest.setWishName(user.get(1).getEmail() + ", " + user.get(1).getSurname());

        List<MovieWish> movieWishList = new ArrayList<>();
        movieWishList.add(movieWish);
        movieWishList.add(movieWish2);
        movieWishList.add(movieWish2EqualsTest);
        return movieWishList;
    }
}
