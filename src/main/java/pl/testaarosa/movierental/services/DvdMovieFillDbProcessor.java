package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.mapper.DvdMovieMapper;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class DvdMovieFillDbProcessor {
    @Autowired
    private DvdMovieService dvdMovieService;
    @Autowired
    private DvdMovieMapper dvdMovieMapper;
    @Autowired
    private DvdMovieRetriver dvdMovieRetriver;

    public void FillDvdMovieDb() throws IOException, URISyntaxException {
        for (DvdMovieDto dvdMovieDto : dvdMovieRetriver.DvdFillStructure()) {
            DvdMovie dvdMovie = dvdMovieMapper
                    .mapToMovieFromSupplierOne(dvdMovieDto);
            dvdMovieService.addDvdMovie(dvdMovie);
        }
    }
}
