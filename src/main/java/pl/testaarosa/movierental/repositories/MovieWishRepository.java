package pl.testaarosa.movierental.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.testaarosa.movierental.domain.MovieWish;

import java.util.List;

public interface MovieWishRepository extends CrudRepository<MovieWish, Long> {

    List<MovieWish> findAll();

    @Query
    MovieWish findAllUsersWishForGivenUser(@Param("userId") Long userId);

}
