package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.DvdMovieDetails;
import pl.testaarosa.movierental.repositories.DvdMovieRpository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class DvdMovieServiceImpl implements DvdMovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DvdMovieServiceImpl.class);
    @Autowired
    private DvdMovieRpository dvdMovieRpository;

    @Override
    public DvdMovie addDvdMovie(final DvdMovie dvdMovie, DvdMovieDetails details) throws IOException, URISyntaxException {
        String movieId = dvdMovie.getImdbID();
        DvdMovie dvdMovie1 = new DvdMovie();
        if (!dvdMovieRpository.existsAllByImdbID(movieId)) {
            dvdMovie1 = dvdMovie;
            dvdMovie1.setDvdMovieDetails(details);
            dvdMovieRpository.save(dvdMovie1);
        }
        return dvdMovie1;
    }

    @Override
    public List<DvdMovie> findAll() {
        return dvdMovieRpository.findAll();
    }

    @Override
    public DvdMovie findById(Long id) throws MovieNotFoundException {
        DvdMovie one = null;
        if (dvdMovieRpository.findOne(id) == null) {
            LOGGER.error("\033[31mCan't find dvd movie id: " + id + "\033[0m");
            throw new MovieNotFoundException("-> Can't find dvd movie id: " + id);
        } else {
            one = dvdMovieRpository.findOne(id);
        }
        return one;
    }

    @Override
    public List<DvdMovie> findByTitle(String title) {
        return dvdMovieRpository.findAllByTitleContaining(title);
    }

}
