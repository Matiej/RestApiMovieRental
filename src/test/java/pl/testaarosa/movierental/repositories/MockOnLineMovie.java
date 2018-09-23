package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.OnLineMovie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.Optional.ofNullable;

public class MockOnLineMovie {

    private MockOnLineMovieDetails onLineMovieDetails = new MockOnLineMovieDetails();
    private MockMovieWish mockMovieWish = new MockMovieWish();

    public CompletableFuture<List<OnLineMovie>> onLineMovieList() throws ExecutionException, InterruptedException {

        OnLineMovie onLineMovie1 = new OnLineMovie();
//        onLineMovie1.setId(1L);
        onLineMovie1.setTitle("Online TestTitle1");
        onLineMovie1.setImdbID("imdbID_O1");
        onLineMovie1.setYear("1988");
        onLineMovie1.setPoster("www.Online-poster11");
        onLineMovie1.setSupplier("ONLINE MOVIE");
        onLineMovie1.setMovieWishList(mockMovieWish.mockMovieWish());
        onLineMovie1.setOnLineMovieDetails(onLineMovieDetails.onLineMovieDetails().get().get(0));

        OnLineMovie onLineMovie2 = new OnLineMovie();
//        onLineMovie1.setId(2L);
        onLineMovie2.setTitle("Online TestTitle2");
        onLineMovie2.setImdbID("imdbID_O2");
        onLineMovie2.setYear("2010");
        onLineMovie2.setPoster("www.Online-poster12");
        onLineMovie2.setSupplier("ONLINE MOVIE");
        onLineMovie2.setMovieWishList(mockMovieWish.mockMovieWish());
        onLineMovie2.setOnLineMovieDetails(onLineMovieDetails.onLineMovieDetails().get().get(1));

        List<OnLineMovie> onLineMovieList = new ArrayList<>();
        onLineMovieList.add(onLineMovie1);
        onLineMovieList.add(onLineMovie2);
        return CompletableFuture.completedFuture(ofNullable(onLineMovieList).orElse(new ArrayList<>()));
    }
}
