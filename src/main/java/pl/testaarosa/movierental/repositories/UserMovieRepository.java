package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.UserMovie;

import java.util.List;

public interface UserMovieRepository extends CrudRepository<UserMovie, Long> {
    List<UserMovie> findAll();
    UserMovie findById(Long id);
    List<UserMovie> findAllByTitleContaining(String title);
}
