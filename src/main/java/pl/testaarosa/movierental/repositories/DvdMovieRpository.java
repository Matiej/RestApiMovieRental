package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.DvdMovie;

import java.util.List;

public interface DvdMovieRpository extends CrudRepository<DvdMovie, Long> {
    boolean existsAllByImdbID(String movieId);
    List<DvdMovie> findAll();
    List<DvdMovie> findAllByTitleContaining(String title);


}
