package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
