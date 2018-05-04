package pl.testaarosa.movierental.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

public interface BlueRayMovieDetailsRepository extends CrudRepository<BlueRayMovieDetails,Long> {
}
