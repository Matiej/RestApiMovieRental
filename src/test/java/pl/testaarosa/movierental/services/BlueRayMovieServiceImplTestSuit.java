package pl.testaarosa.movierental.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.repositories.BlueRayMovieRepository;
import pl.testaarosa.movierental.repositories.MockBlueRayMovie;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlueRayMovieServiceImplTestSuit {

    private MockBlueRayMovie blueRayMovie = new MockBlueRayMovie();

    @InjectMocks
    private BlueRayMovieServiceImpl blueRayMovieService;

    @Mock
    private BlueRayMovieRepository blueRayMovieRepository;

    @Test
    public void testFindAll(){
        //given
        when(blueRayMovieRepository.findAll()).thenReturn(blueRayMovie.blueRayMovieList());
        //when
        int result = blueRayMovieService.findAll().size();
        int expect = 4;
        //then
        assertEquals(expect,result);
        assertEquals(blueRayMovie.blueRayMovieList(), blueRayMovieRepository.findAll());
    }

    @Test
    public void testFindbyId() throws MovieNotFoundException {
        //given
        BlueRayMovie expect = blueRayMovie.blueRayMovieList().get(1);
        when(blueRayMovieRepository.findOne(2L)).thenReturn(expect);
        //when
        BlueRayMovie result = blueRayMovieService.findbyId(2L);
        //then
        assertEquals(expect, result);
    }

    @Test
    public void testFindAllContainsTitle(){
        //given
        List<BlueRayMovie> expect = blueRayMovie.blueRayMovieList();
        when(blueRayMovieRepository.findAllByTitleContaining("title3")).thenReturn(expect);
        //when
        List<BlueRayMovie> result = blueRayMovieService.findAllContainsTitle("title3");
        List<BlueRayMovie> wrongResult = blueRayMovieRepository.findAllByTitleContaining("Title4");
        //then
        assertEquals(expect, result);
        assertNotEquals(expect, wrongResult);
        assertEquals(expect.size(), result.size());
        assertEquals(0, wrongResult.size());
    }

    @Test
    public void testAddBlueRayMoviesTrue() {
        //given
        BlueRayMovie emptyMovie = new BlueRayMovie();
        BlueRayMovie blueRayMovie1 = blueRayMovie.blueRayMovieList().get(1);
        when(blueRayMovieRepository.save(blueRayMovie1)).thenReturn(emptyMovie);
        when(blueRayMovieRepository.existsAllByImdbID(blueRayMovie1.getImdbID())).thenReturn(true);
        //when
        BlueRayMovie result = blueRayMovieService.addBlueRayMovies(blueRayMovie1, blueRayMovie1.getBlueRayMovieDetails());
        //then
        assertEquals(emptyMovie,result);
    }

    @Test
    public void testAddBlueRayMoviesFalse() {
        //given
        BlueRayMovie blueRayMovie1 = blueRayMovie.blueRayMovieList().get(1);
        when(blueRayMovieRepository.existsAllByImdbID(blueRayMovie1.getImdbID())).thenReturn(false);
        when(blueRayMovieRepository.save(blueRayMovie1)).thenReturn(blueRayMovie1);
        //when
        BlueRayMovie result = blueRayMovieService.addBlueRayMovies(blueRayMovie1, blueRayMovie1.getBlueRayMovieDetails());
        //then
        assertEquals(blueRayMovie1,result);
    }
}
