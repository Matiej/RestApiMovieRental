package pl.testaarosa.movierental.mapper.form;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;

@Component
public class UserMovieFormDtoMapper {

    public UserMovieForm mapToUserMovieForm(UserMovieFormDto userMovieFormDto){
        return new UserMovieForm(
                userMovieFormDto.getImdbID(),
                userMovieFormDto.getTitle(),
                userMovieFormDto.getYear(),
                userMovieFormDto.getPoster(),
                userMovieFormDto.getGenre(),
                userMovieFormDto.getRuntime(),
                userMovieFormDto.getUserOpinion(),
                userMovieFormDto.getActors(),
                userMovieFormDto.getPlot());

    }
}
