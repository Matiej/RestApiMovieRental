package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
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

    public CompletableFuture<List<BlueRayMovie>> fillBlueRayDb(String title) throws ExecutionException, InterruptedException {
        CompletableFuture<List<BlueRayMovie>> paginationBlueRay = blueRayMovieRetriever.getPaginationBlueRay(title);
        paginationBlueRay.get().parallelStream().forEach(b -> {
            String imdbID = b.getImdbID();
            CompletableFuture<BlueRayMovieDetails> details = null;
            details = getDet(imdbID);
            CompletableFuture.allOf(details);
//            try {
//                details = getDet(imdbID);
//                CompletableFuture.allOf(details);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
            try {
                blueRayMovieService.addBlueRayMovies(b, details.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        return paginationBlueRay;
    }

    private CompletableFuture<BlueRayMovieDetails> getDet(String moiveId) {
        return blueRayMovieRetriever.getMovieDetails(moiveId);
    }
}
