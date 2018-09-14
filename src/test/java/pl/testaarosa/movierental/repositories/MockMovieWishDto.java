package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;

import java.util.ArrayList;
import java.util.List;

public class MockMovieWishDto {

    private MockUser mockUser = new MockUser();

    public List<MovieWishDto> mockMovieWishDtos() {

        List<User> user = mockUser.mockUser();
        MovieWishDto movieWish = new MovieWishDto(
                1L,
                user.get(0).getEmail() + ", " + user.get(0).getSurname(),
                null,
                user.get(0));

        MovieWishDto movieWish2 = new MovieWishDto(
                2L,
                user.get(1).getEmail() + ", " + user.get(1).getSurname(),
                null,
                user.get(1));

        List<MovieWishDto> movieWishList = new ArrayList<>();
        movieWishList.add(movieWish);
        movieWishList.add(movieWish2);
        return movieWishList;
    }
}
