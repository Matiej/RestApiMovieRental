package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.form.UserMovieForm;

@Component
public class UserMovieFormMapper {

    public UserMovie mapToUserMovie(UserMovieForm userMovieForm){
        return new UserMovie.UserMovieBuilder()
                .title(userMovieForm.getTitle())
                .genre(userMovieForm.getGenre())
                .imdbID(userMovieForm.getImdbID())
                .build();
    }

    public UserMovieDetails mapToUserMovieDetails(UserMovieForm userMovieForm){
        return new UserMovieDetails.UserMovieDetailsBuilder()
                .year(userMovieForm.getYear())
                .poster(userMovieForm.getPoster())
                .runtime(userMovieForm.getRuntime())
                .userOpinion(userMovieForm.getUserOpinion())
                .actors(userMovieForm.getActors())
                .plot(userMovieForm.getPlot())
                .build();

    }
}
