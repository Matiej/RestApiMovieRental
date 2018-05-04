package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.domain.DvdMovie;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DvdMovieService {
    void addDvdMovie(final DvdMovie dvdMovie) throws IOException, URISyntaxException;
    List<DvdMovie> findAll();
    DvdMovie findById(Long id);
    List<DvdMovie> findByTitle(String title);
}
