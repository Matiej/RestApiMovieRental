package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.dto.MovieDto;

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
}
