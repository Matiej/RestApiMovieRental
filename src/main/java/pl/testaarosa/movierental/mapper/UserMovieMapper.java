package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;

@Component
public class UserMovieMapper {

    public UserMovie mapToUserMovie(UserMovieDto userMovieDto){
        return UserMovie.builder()
                .imdbID(userMovieDto.getImdbID())
                .title(userMovieDto.getTitle())
                .year(userMovieDto.getYear())
                .poster(userMovieDto.getPoster())
                .build();
    }

    public UserMovieDto mapToUserMovieDto(UserMovie userMovie){
        return  UserMovieDto.builder()
                .imdbID(userMovie.getImdbID())
                .title(userMovie.getTitle())
                .year(userMovie.getYear())
                .poster(userMovie.getPoster())
                .build();
    }

}
