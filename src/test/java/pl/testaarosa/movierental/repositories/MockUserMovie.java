package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieGenre;

import java.util.ArrayList;
import java.util.List;

public class MockUserMovie {

    private MockUserMovieDetails details = new MockUserMovieDetails();
    private MockUser mockUser = new MockUser();

    public List<UserMovie> userMovieList() {
        UserMovie userMovie1 = UserMovie.builder()
                .imdbID("xxx1")
                .title("My Nice Movie1")
                .genre(UserMovieGenre.ROMANCE)
                .userMovieDetails(details.userMovieDetails().get(0))
                .user(mockUser.mockUser().get(0))
                .build();
        UserMovie userMovie2 = UserMovie.builder()
                .imdbID("xxx2")
                .title("My Nice Movie2")
                .genre(UserMovieGenre.ROMANCE)
                .userMovieDetails(details.userMovieDetails().get(1))
                .user(mockUser.mockUser().get(1))
                .build();
        UserMovie userMovie2EqualsTest = UserMovie.builder()
                .imdbID("xxx2")
                .title("My Nice Movie2")
                .genre(UserMovieGenre.ROMANCE)
                .userMovieDetails(details.userMovieDetails().get(1))
                .user(mockUser.mockUser().get(1))
                .build();

        List<UserMovie> userMovieList = new ArrayList<>();
        userMovieList.add(userMovie1);
        userMovieList.add(userMovie2);
        userMovieList.add(userMovie2EqualsTest);
        return userMovieList;
    }
}
