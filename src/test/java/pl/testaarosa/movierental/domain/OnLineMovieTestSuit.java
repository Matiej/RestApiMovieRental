package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockOnLineMovie;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnLineMovieTestSuit {

    private MockOnLineMovie mockOnLineMovie = new MockOnLineMovie();

    @Test
    public void testOnLineMovie() throws ExecutionException, InterruptedException {
        CompletableFuture<List<OnLineMovie>> listCompletableFuture = mockOnLineMovie.onLineMovieList();
        OnLineMovie onLineMovie1 = listCompletableFuture.get().get(1);
        OnLineMovie onLineMovie2 = listCompletableFuture.get().get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(onLineMovie1,onLineMovie2).testEquals();
    }
}
