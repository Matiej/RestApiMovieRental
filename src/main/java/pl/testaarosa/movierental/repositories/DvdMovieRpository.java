package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.testaarosa.movierental.domain.DvdMovie;

import java.util.List;

public interface DvdMovieRpository extends PagingAndSortingRepository<DvdMovie, Long> {
    boolean existsAllByImdbID(String movieId);
    @Override
    List<DvdMovie> findAll();
    List<DvdMovie> findAllByTitleContaining(String title);

}
