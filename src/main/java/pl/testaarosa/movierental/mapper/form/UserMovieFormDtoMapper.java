package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;

@Component
public class UserMovieFormDtoMapper {

    public UserMovieForm mapToUserMovieForm(UserMovieFormDto userMovieFormDto){
        return UserMovieForm.builder()
                .imdbID(userMovieFormDto.getImdbID())
                .title(userMovieFormDto.getTitle())
                .year(userMovieFormDto.getYear())
                .plot(userMovieFormDto.getPlot())
                .genre(userMovieFormDto.getGenre())
                .runtime(userMovieFormDto.getRuntime())
                .userOpinion(userMovieFormDto.getUserOpinion())
                .actors(userMovieFormDto.getActors())
                .poster(userMovieFormDto.getPoster())
                .build();
    }

    public UserMovieFormDto maptToUserMovieFormDto(UserMovieForm userMovieForm){
        return null;
    }
}
