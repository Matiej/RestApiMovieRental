package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.OnLineMovie;

public interface OnLineMovieRepository extends CrudRepository<OnLineMovie, Long> {
    boolean existsAllByImdbID(String imdbID);
    OnLineMovie findByImdbID(String imdbID);
}
