package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.dto.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper{

    public Movie mapToMovie(MovieDto movieDto) {
        return new Movie(
             movieDto.getTitle(),
             movieDto.getImdbID(),
             movieDto.getPoster(),
             movieDto.getSupplier()
        );
    }

    public MovieDto mapToMovieDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getImdbID(),
                movie.getPoster(),
                movie.getSupplier(),
                movie.getMovieWishList()
        );
    }

    public List<MovieDto> mapTOMovieDtoList(List<Movie> movieList) {
        return movieList.stream()
                .map(t -> new MovieDto(
                        t.getId(),
                        t.getTitle(),
                        t.getImdbID(),
                        t.getPoster(),
                        t.getSupplier(),
                        t.getMovieWishList()))
                .collect(Collectors.toList());
    }
}
