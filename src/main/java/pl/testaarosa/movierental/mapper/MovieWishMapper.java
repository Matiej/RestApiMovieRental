package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieWishMapper {

    public MovieWishDto mapToMovieWishDto(MovieWish movieWish) {
        return new MovieWishDto(
                movieWish.getId(),
                movieWish.getWishName(),
                movieWish.getMoviesList(),
                movieWish.getUser());
    }

    public List<MovieWishDto> mapToMovieWishDtoList(List<MovieWish> movieWishList) {
        return movieWishList.stream()
                .map(m-> new MovieWishDto(
                        m.getId(),
                        m.getWishName(),
                        m.getMoviesList(),
                        m.getUser()))
                .collect(Collectors.toList());
    }

    public MovieWish mapToMovieWish(MovieWishDto movieWishDto) {
        return new MovieWish.MovieWishBuilder()
                .wishName(movieWishDto.getWishName())
                .movieList(movieWishDto.getMoviesList())
                .user(movieWishDto.getUser())
                .builder();
    }
}
