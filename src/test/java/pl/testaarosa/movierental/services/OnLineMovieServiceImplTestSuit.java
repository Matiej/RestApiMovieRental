package pl.testaarosa.movierental.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.mapper.OmbdOnLineMapper;
import pl.testaarosa.movierental.repositories.MockOnLineMovie;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetails;
import pl.testaarosa.movierental.repositories.OnLineMovieRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OnLineMovieServiceImplTestSuit {

    private MockOnLineMovie mockOnLineMovie = new MockOnLineMovie();
    private MockOnLineMovieDetails mockOnLineMovieDetails = new MockOnLineMovieDetails();

    @InjectMocks
    private OnLineMovieServiceImpl onLineMovieService;

    @Mock
    private OnLineMovieRepository onLineMovieRepository;
    @Mock
    private OnLineMovieRetriever onLineMovieRetriever;
    @Mock
    private OmbdOnLineMapper ombdOnLineMapper;

    @Test
    public void testGetOnLineMovies() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<List<OnLineMovie>> expectList = mockOnLineMovie.onLineMovieList();
        when(onLineMovieRetriever.getOnLineMovies("Online TestTitle1")).thenReturn(expectList);
        List<OnLineMovie> resultList = onLineMovieService.getOnLineMovies("Online TestTitle1");
        //when
        int result = resultList.size();
        int expect = 2;
        //then
        assertEquals(expect,result);
        assertEquals(expectList.get(),resultList);
    }

    @Test
    public void testGetOnLineMovieDetails() throws ExecutionException, InterruptedException {
        //given
        OnLineMovieDetails expectOnLineMovieDetails = mockOnLineMovieDetails.onLineMovieDetails().get().get(1);
        when(onLineMovieRetriever.getOnLineMovieDetails("MovieId"))
                .thenReturn(CompletableFuture.completedFuture(ofNullable(expectOnLineMovieDetails)
                        .orElse(new OnLineMovieDetails())));
        //when
        OnLineMovieDetails result = onLineMovieService.getOnLineMovieDetails("MovieId");
        //then
        assertEquals(expectOnLineMovieDetails,result);
    }

    @Test
    public void testAddOnLineMovieToDbFalse() throws ExecutionException, InterruptedException {
        //given
        OnLineMovieDetails onLineMovieDetails = mockOnLineMovieDetails.onLineMovieDetails().get().get(0);
        when(onLineMovieRetriever.getOnLineMovieDetails("xxx"))
                .thenReturn(CompletableFuture.completedFuture(ofNullable(onLineMovieDetails).orElse(new OnLineMovieDetails())));
        OnLineMovie expectOnLineMovie = mockOnLineMovie.onLineMovieList().get().get(0);
        when(ombdOnLineMapper.mapToOnLineMovie(onLineMovieDetails)).thenReturn(expectOnLineMovie);
        when(onLineMovieRepository.existsAllByImdbID("xxx")).thenReturn(false);
        when(onLineMovieRepository.save(expectOnLineMovie)).thenReturn(expectOnLineMovie);
        //when
        OnLineMovie result = onLineMovieService.addOnLineMovieToDb("xxx");
        //then
        assertEquals(expectOnLineMovie,result);
    }

    @Test
    public void testAddOnLineMovieToDbTrue() throws ExecutionException, InterruptedException {
        //given
        OnLineMovieDetails onLineMovieDetails = mockOnLineMovieDetails.onLineMovieDetails().get().get(0);
        when(onLineMovieRetriever.getOnLineMovieDetails("xxx"))
                .thenReturn(CompletableFuture.completedFuture(ofNullable(onLineMovieDetails).orElse(new OnLineMovieDetails())));
        OnLineMovie expectOnLineMovie = mockOnLineMovie.onLineMovieList().get().get(0);
        when(ombdOnLineMapper.mapToOnLineMovie(onLineMovieDetails)).thenReturn(expectOnLineMovie);
        when(onLineMovieRepository.existsAllByImdbID("xxx")).thenReturn(true);
        when(onLineMovieRepository.findByImdbID("xxx")).thenReturn(expectOnLineMovie);
        //when
        OnLineMovie result = onLineMovieService.addOnLineMovieToDb("xxx");
        //then
        assertEquals(expectOnLineMovie,result);
    }

    @Test
    public void testFindById() throws ExecutionException, InterruptedException {
        //given
        OnLineMovie expectOnLineMovie = mockOnLineMovie.onLineMovieList().get().get(1);
        OnLineMovie notExpectOnLineMovie = mockOnLineMovie.onLineMovieList().get().get(0);
        when(onLineMovieRepository.findOne(2L)).thenReturn(expectOnLineMovie);
        //when
        OnLineMovie result = onLineMovieService.findById(2L);
        //then
        assertEquals(expectOnLineMovie,result);
        assertNotEquals(notExpectOnLineMovie,result);
    }
}
