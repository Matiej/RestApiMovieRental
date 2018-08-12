package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.DvdMovieDetails;
import pl.testaarosa.movierental.repositories.DvdMovieRpository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class DvdMovieServiceImpl implements DvdMovieService {
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
    public List<DvdMovie> findAll(){
        return dvdMovieRpository.findAll();
    }

    @Override
    public DvdMovie findById(Long id){
        return dvdMovieRpository.findOne(id);
    }

    @Override
    public List<DvdMovie> findByTitle(String title){
        return dvdMovieRpository.findAllByTitleContaining(title);
    }

}
