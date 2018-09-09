package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserMovieGenre;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;

import java.util.ArrayList;
import java.util.List;

public class MockUserMovieFormDto {

    public List<UserMovieFormDto> userMovieFormList() {

        UserMovieFormDto userMovieForm1 = new UserMovieFormDto(
                null,
                "xxx1",
                "My Nice Movie1",
                "1999",
                "sUser_Poster1",
                UserMovieGenre.ROMANCE,
                "User_Runtime1",
                "bestmy Movie1",
                "Stefan Batory1",
                "Plot from user1"
        );

        UserMovieFormDto userMovieForm2 = new UserMovieFormDto(
                null,
                "xxx2",
                "My Nice Movie2",
                "2001",
                "sUser_Poster2",
                UserMovieGenre.COMEDY,
                "User_Runtime2",
                "bestmy Movie2",
                "Stefan Batory2",
                "Plot from user2"
        );

        List<UserMovieFormDto> userMovieFormList = new ArrayList<>();
        userMovieFormList.add(userMovieForm1);
        userMovieFormList.add(userMovieForm2);
        return userMovieFormList;
    }

}
