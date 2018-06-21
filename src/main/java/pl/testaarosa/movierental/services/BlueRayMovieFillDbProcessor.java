package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class BlueRayMovieFillDbProcessor {
    @Autowired
    private BlueRayMovieRetriever blueRayMovieRetriever;
    @Autowired
    private BlueRayMovieService blueRayMovieService;

//    @Async
    public void FillBlueRayDb(String title) throws ExecutionException, InterruptedException {
        CompletableFuture<List<BlueRayMovie>> paginationBlueRay = blueRayMovieRetriever.getPaginationBlueRay(title);
        paginationBlueRay.get().forEach(b->{
            String imdbID = b.getImdbID();
            BlueRayMovieDetails details = null;
            try {
                details = getDet(imdbID).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            blueRayMovieService.addBlueRayMovies(b,details);
        });
    }

    private CompletableFuture<BlueRayMovieDetails> getDet(String moiveId) {
        return blueRayMovieRetriever.getMovieDetails(moiveId);
    }
}
