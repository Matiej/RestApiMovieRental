package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMovieMapper {

    public List<UserMovieDto> mapToUserMovieDtoList(List<UserMovie> userMovieList) {
        return userMovieList.stream()
                .map(u-> new UserMovieDto(
                        u.getId(),
                        u.getImdbID(),
                        u.getTitle(),
                        u.getGenre(),
                        u.getUserMovieDetails(),
                        u.getUser()))
                .collect(Collectors.toList());
    }

    public UserMovieDto mapToUserMovieDto(UserMovie userMovie){
        return new UserMovieDto(
                userMovie.getId(),
                userMovie.getImdbID(),
                userMovie.getTitle(),
                userMovie.getGenre(),
                userMovie.getUserMovieDetails(),
                userMovie.getUser());
    }
}
