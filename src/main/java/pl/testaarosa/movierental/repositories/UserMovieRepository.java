package pl.testaarosa.movierental.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.testaarosa.movierental.domain.UserMovie;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

public interface UserMovieRepository extends CrudRepository<UserMovie, Long> {

    @Override
    List<UserMovie> findAll();
    UserMovie findById(Long id);
    @Query
    List<UserMovie> findAllUserMoviesByTitleContaining(@Param("userId") Long userId, @Param("title") String title);
    @Query
    List<UserMovie> findAllUsersMoviesForGivenUser(@Param("userId") Long userId);
}
