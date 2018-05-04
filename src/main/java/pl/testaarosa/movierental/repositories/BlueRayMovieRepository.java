package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.BlueRayMovie;

import java.util.List;

public interface BlueRayMovieRepository extends CrudRepository<BlueRayMovie, Long> {
    boolean existsAllByImdbID(String movieImdbId);
    List<BlueRayMovie> findAll();
    List<BlueRayMovie> findAllByTitleContaining(String title);
}
