package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.MoviesWish;

import java.util.List;

public interface MoviesWishListRepository extends CrudRepository<MoviesWish, Long> {
    List<MoviesWish> findAll();

}
