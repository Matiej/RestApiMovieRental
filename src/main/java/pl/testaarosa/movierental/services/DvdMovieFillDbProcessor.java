package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.DvdMovieDetails;
import pl.testaarosa.movierental.mapper.DvdMovieMapper;
import pl.testaarosa.movierental.mapper.OneDvdDetilsMapper;
import pl.testaarosa.movierental.mapper.OneDvdMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

@Service
public class DvdMovieFillDbProcessor {
    @Autowired
    private DvdMovieService dvdMovieService;
    @Autowired
    private DvdMovieRetriver dvdMovieRetriver;
    @Autowired
    private OneDvdMapper dvdMovieMapper;
    @Autowired
    private OneDvdDetilsMapper detailsMapper;

    public void FillDvdMovieDb() throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        dvdMovieRetriver.DvdFillStructure().get().forEach(f-> {
            try {
                dvdMovieService.addDvdMovie(dvdMovieMapper.mapToDvdMovie(f),detailsMapper.matpToOneDvdDetails(f));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }
}
