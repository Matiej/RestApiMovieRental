package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.form.dto.UserrMovieFormDto;

@Component
public class UserMovieFormDtoMapper {

    public UserMovieForm mapToUserMovieForm(UserrMovieFormDto userrMovieFormDto){
        return UserMovieForm.builder()
                .imdbID(userrMovieFormDto.getImdbID())
                .title(userrMovieFormDto.getTitle())
                .year(userrMovieFormDto.getYear())
                .plot(userrMovieFormDto.getPlot())
                .genre(userrMovieFormDto.getGenre())
                .runtime(userrMovieFormDto.getRuntime())
                .userOpinion(userrMovieFormDto.getUserOpinion())
                .actors(userrMovieFormDto.getActors())
                .poster(userrMovieFormDto.getPoster())
                .build();
    }
}
