package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserMovieGenre;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;

import java.util.ArrayList;
import java.util.List;

public class MockUserMovieDto {

    private MockUserMovieDetails userMovieDetails = new MockUserMovieDetails();
    private MockUser mockUser = new MockUser();

    public List<UserMovieDto> mockUserMovieList() {
        UserMovieDto userMovie1 = new UserMovieDto(
                null,
                "xxx1",
                "My Nice Movie1",
                UserMovieGenre.ROMANCE,
                userMovieDetails.userMovieDetails().get(0),
                mockUser.mockUser().get(0)
        );
        UserMovieDto userMovie2 = new UserMovieDto(
                null,
                "xxx2",
                "My Nice Movie2",
                UserMovieGenre.ROMANCE,
                userMovieDetails.userMovieDetails().get(1),
                mockUser.mockUser().get(1)
        );

        UserMovieDto userMovie2EqualsTest = new UserMovieDto(
                null,
                "xxx2",
                "My Nice Movie2",
                UserMovieGenre.ROMANCE,
                userMovieDetails.userMovieDetails().get(1),
                mockUser.mockUser().get(1)
        );
        List<UserMovieDto> userMovieList = new ArrayList<>();
        userMovieList.add(userMovie1);
        userMovieList.add(userMovie2);
        userMovieList.add(userMovie2EqualsTest);
        return userMovieList;
    }
}
