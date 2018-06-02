package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

@Service
public class BlueRayMovieFillDbProcessor {
    @Autowired
    private BlueRayMovieRetriever blueRayMovieRetriever;
    @Autowired
    private BlueRayMovieService blueRayMovieService;

    public void FillBlueRayDb(String title) {
        blueRayMovieRetriever.getPaginationBlueRay(title).forEach(b->{
            String imdbID = b.getImdbID();
            BlueRayMovieDetails details = getDet(imdbID);
            blueRayMovieService.addBlueRayMovies(b,details);
        });
    }

    private BlueRayMovieDetails getDet(String moiveId) {
        return blueRayMovieRetriever.getMovieDetails(moiveId);
    }
}
