package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.MoviesWishList;

import java.util.List;

public interface MoviesWishListRepository extends CrudRepository<MoviesWishList, Long> {
    List<MoviesWishList> findAll();

}
