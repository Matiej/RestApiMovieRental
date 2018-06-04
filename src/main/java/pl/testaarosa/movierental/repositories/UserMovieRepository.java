package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.UserMovie;

import java.util.List;
import java.util.Optional;

public interface UserMovieRepository extends CrudRepository<UserMovie, Long> {

    @Override
    List<UserMovie> findAll();

    UserMovie findById(Long id);

    List<UserMovie> findAllByTitleContaining(String title);
}
