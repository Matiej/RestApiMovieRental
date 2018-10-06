package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.UserMovieDetails;

import java.util.ArrayList;
import java.util.List;

public class MockUserMovieDetails {

    public List<UserMovieDetails> userMovieDetails() {
        UserMovieDetails userMovieDetails1 = UserMovieDetails.builder()
                .year("1999")
                .poster("sUser_Poster1")
                .runtime("User_Runtime1")
                .userOpinion("bestmy Movie1")
                .actors("Stefan Batory1")
                .plot("Plot from user1")
                .build();

        UserMovieDetails userMovieDetails2 = UserMovieDetails.builder()
                .year("2001")
                .poster("sUser_Poster2")
                .runtime("User_Runtime2")
                .userOpinion("bestmy Movie2")
                .actors("Stefan Batory2")
                .plot("Plot from user2")
                .build();

        UserMovieDetails userMovieDetails2EqualsTest = UserMovieDetails.builder()
                .year("2001")
                .poster("sUser_Poster2")
                .runtime("User_Runtime2")
                .userOpinion("bestmy Movie2")
                .actors("Stefan Batory2")
                .plot("Plot from user2")
                .build();

        List<UserMovieDetails> userMovieDetails = new ArrayList<>();
        userMovieDetails.add(userMovieDetails1);
        userMovieDetails.add(userMovieDetails2);
        userMovieDetails.add(userMovieDetails2EqualsTest);
        return userMovieDetails;
    }
}
