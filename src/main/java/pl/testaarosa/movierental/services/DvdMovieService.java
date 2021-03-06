package pl.testaarosa.movierental.services;

import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.DvdMovieDetails;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DvdMovieService {
    DvdMovie addDvdMovie(final DvdMovie dvdMovie, DvdMovieDetails details) throws IOException, URISyntaxException;
    List<DvdMovie> findAll();
    DvdMovie findById(Long id) throws MovieNotFoundException;
    List<DvdMovie> findByTitle(String title);
}
