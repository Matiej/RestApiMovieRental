package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetails;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnLineMovieDetailsTestSuit {

    private MockOnLineMovieDetails mockOnLineMovieDetails = new MockOnLineMovieDetails();

    @Test
    public void testOnLineMovieDetails() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<List<OnLineMovieDetails>> listCompletableFuture = mockOnLineMovieDetails.onLineMovieDetails();
        OnLineMovieDetails onLineMovieDetails11 = listCompletableFuture.get().get(1);
        OnLineMovieDetails onLineMovieDetails12 = listCompletableFuture.get().get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(onLineMovieDetails11,onLineMovieDetails12).testEquals();
    }

}
