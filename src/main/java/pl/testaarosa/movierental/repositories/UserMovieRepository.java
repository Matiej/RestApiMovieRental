package pl.testaarosa.movierental.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.testaarosa.movierental.domain.UserMovie;

import java.util.List;

public interface UserMovieRepository extends CrudRepository<UserMovie, Long> {

    @Override
    List<UserMovie> findAll();
    UserMovie findById(Long id);
    @Query
    List<UserMovie> findAllUserMoviesByTitleContaining(@Param("userId") Long userId, @Param("title") String title);
    @Query
    List<UserMovie> findAllUsersMoviesForGivenUser(@Param("userId") Long userId);


    @Transactional
    @Modifying
    @Query
    void deleteMoviesForGivenUser(@Param("userId") Long userId);
}
