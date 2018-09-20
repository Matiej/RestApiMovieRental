package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.form.UserMovieForm;

@Component
public class UserMovieFormMapper {

    public UserMovie mapToUserMovie(UserMovieForm userMovieForm) {
        return UserMovie.builder()
                .imdbID(userMovieForm.getImdbID())
                .title(userMovieForm.getTitle())
                .genre(userMovieForm.getGenre())
                .build();

//        return new UserMovie.UserMovieBuilder()
//                .title(userMovieForm.getTitle())
//                .genre(userMovieForm.getGenre())
//                .imdbID(userMovieForm.getImdbID())
//                .build();
    }

    public UserMovieDetails mapToUserMovieDetails(UserMovieForm userMovieForm) {
        return UserMovieDetails.builder()
                .year(userMovieForm.getYear())
                .poster(userMovieForm.getPoster())
                .runtime(userMovieForm.getRuntime())
                .userOpinion(userMovieForm.getUserOpinion())
                .actors(userMovieForm.getActors())
                .plot(userMovieForm.getPlot())
                .build();
    }
}
