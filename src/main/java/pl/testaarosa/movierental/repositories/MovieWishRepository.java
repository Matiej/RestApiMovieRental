package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;

import java.util.List;

public interface MovieWishRepository extends CrudRepository<MovieWish, Long> {

    List<MovieWish> findAll();
}
