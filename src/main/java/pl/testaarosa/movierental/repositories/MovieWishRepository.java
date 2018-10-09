package pl.testaarosa.movierental.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.testaarosa.movierental.domain.MovieWish;

import java.util.List;

public interface MovieWishRepository extends CrudRepository<MovieWish, Long> {

    List<MovieWish> findAll();

    @Query
    MovieWish findAllUsersWishForGivenUser(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query
    void deleteWishesForGivenUser(@Param("userId") Long userId);
}
