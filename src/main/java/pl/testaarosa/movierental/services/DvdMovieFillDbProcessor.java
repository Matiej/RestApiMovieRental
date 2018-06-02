package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.mapper.DvdMovieMapper;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class DvdMovieFillDbProcessor {
    @Autowired
    private DvdMovieService dvdMovieService;
    @Autowired
    private DvdMovieRetriver dvdMovieRetriver;

    public void FillDvdMovieDb() throws IOException, URISyntaxException {
        dvdMovieRetriver.DvdFillStructure().forEach(f-> {
            try {
                dvdMovieService.addDvdMovie(f);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }
}
