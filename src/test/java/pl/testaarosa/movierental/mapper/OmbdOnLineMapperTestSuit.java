package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDto;
import pl.testaarosa.movierental.repositories.MockOmdbOnLineDto;
import pl.testaarosa.movierental.repositories.MockOnLineMovie;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OmbdOnLineMapperTestSuit {

    @InjectMocks
    private OmbdOnLineMapper ombdOnLineMapper;

    private MockOnLineMovie mockOnLineMovie = new MockOnLineMovie();
    private List<OnLineMovie> onLineMovieList;
    private MockOmdbOnLineDto mockOmdbOnLineDto = new MockOmdbOnLineDto();
    private List<OmdbOnLineDto> omdbOnLineDtoList;
    private MockOnLineMovieDetails mockOnLineMovieDetail = new MockOnLineMovieDetails();
    private List<OnLineMovieDetails> onLineMovieDetailsList;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        onLineMovieList = mockOnLineMovie.onLineMovieList().get();
        omdbOnLineDtoList = mockOmdbOnLineDto.omdbOnLineDtoList();
        onLineMovieDetailsList = mockOnLineMovieDetail.onLineMovieDetails().get();
    }

    @Test
    public void shouldmapToOnLineMovie1() {
        //given
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(0);
        OnLineMovie onLineMovie = onLineMovieList.get(0);
        onLineMovie.setMovieWishList(new ArrayList<>());
        onLineMovie.setOnLineMovieDetails(null);
        //when
        OnLineMovie result = ombdOnLineMapper.mapToOnLineMovie(onLineMovieDetails);
        //then
        assertEquals(onLineMovie, result);
        assertNull(result.getOnLineMovieDetails());
        assertEquals(onLineMovie.getSupplier(), result.getSupplier());
    }

    @Test
    public void shouldmapToOnLineMovie2() {
        //given
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(1);
        OnLineMovie onLineMovie = onLineMovieList.get(1);
        onLineMovie.setMovieWishList(new ArrayList<>());
        onLineMovie.setOnLineMovieDetails(null);
        //when
        OnLineMovie result = ombdOnLineMapper.mapToOnLineMovie(onLineMovieDetails);
        //then
        assertEquals(onLineMovie, result);
        assertNotNull(result.getMovieWishList());
        assertEquals(onLineMovie.getSupplier(), result.getSupplier());
    }

    @Test
    public void shouldNotmapToOnLineMovie() {
        //given
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(1);
        OnLineMovie onLineMovie = onLineMovieList.get(0);
        onLineMovie.setMovieWishList(new ArrayList<>());
        onLineMovie.setOnLineMovieDetails(null);
        //when
        OnLineMovie result = ombdOnLineMapper.mapToOnLineMovie(onLineMovieDetails);
        //then
        assertNotEquals(onLineMovie, result);
        assertNotNull(result.getMovieWishList());
        assertNotEquals(onLineMovie.getYear(), result.getYear());
    }

    @Test
    public void shouldMapToOnLineMovieList() {
        //given
        onLineMovieList.forEach(t -> {
            t.setOnLineMovieDetails(null);
            t.setMovieWishList(new ArrayList<>());
        });
        //when
        List<OnLineMovie> result = ombdOnLineMapper.mapToOnLineMovieList(omdbOnLineDtoList);
        //then
        assertEquals(onLineMovieList, result);
        assertEquals(3, result.size());
    }

    @Test
    public void shouldNotMapToOnLineMovieList() {
        //given
        onLineMovieList.forEach(t -> {
            t.setOnLineMovieDetails(null);
            t.setMovieWishList(new ArrayList<>());
            t.setYear("2001");
        });
        //when
        List<OnLineMovie> result = ombdOnLineMapper.mapToOnLineMovieList(omdbOnLineDtoList);
        //then
        assertNotEquals(onLineMovieList, result);
        assertEquals(3, result.size());
        assertNull(result.get(0).getOnLineMovieDetails());
    }


}
