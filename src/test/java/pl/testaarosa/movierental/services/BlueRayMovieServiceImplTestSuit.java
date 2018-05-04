package pl.testaarosa.movierental.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.repositories.BlueRayMovieRepository;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlueRayMovieServiceImplTestSuit {

    private List<BlueRayMovie> blueRayMovieList;

    @InjectMocks
    private BlueRayMovieServiceImpl movieService;

    @Mock
    private BlueRayMovieRepository movieRepository;

    @Before
    public void setUp(){
        blueRayMovieList = new LinkedList<>();
        BlueRayMovie blueRayMovie1 = BlueRayMovie.builder()
                .id(1L)
                .imdbID("ttimdBID1")
                .poster("poster1 https")
                .title("Test Title1")
                .type("comedy")
                .year("2018")
                .build();

        BlueRayMovie blueRayMovie2 = BlueRayMovie.builder()
                .id(2L)
                .imdbID("ttimdBID2")
                .poster("poster2 https")
                .title("Test Title2")
                .type("sfc")
                .year("2015")
                .build();

        BlueRayMovie blueRayMovie3 = BlueRayMovie.builder()
                .id(3L)
                .imdbID("ttimdBID2")
                .poster("poster3 https")
                .title("Test Title3")
                .type("drama")
                .year("2014")
                .build();

        blueRayMovieList.add(blueRayMovie1);
        blueRayMovieList.add(blueRayMovie2);
        blueRayMovieList.add(blueRayMovie3);

    }

    @Test
    public void testFindAll(){
        //given
        when(movieRepository.findAll()).thenReturn(blueRayMovieList);
        //when
        int result = movieService.findAll().size();
        int expect = 3;
        //then
        assertEquals(expect,result);
        assertEquals(blueRayMovieList, movieRepository.findAll());
    }

    @Test
    public void testFindbyId(){
        //given
        when(movieRepository.findOne(2L)).thenReturn(blueRayMovieList.get(1));
        //when
        BlueRayMovie result = movieService.findbyId(2L);
        //then
        assertEquals(blueRayMovieList.get(1), result);

    }

    @Test
    public void testFindAllContainsTitle(){
        //given
        when(movieRepository.findAllByTitleContaining("Title3")).thenReturn(blueRayMovieList);
        //when
        List<BlueRayMovie> result = movieService.findAllContainsTitle("Title3");
        List<BlueRayMovie> wrongResult = movieRepository.findAllByTitleContaining("Title4");
        //then
        assertEquals(blueRayMovieList, result);
        assertNotEquals(blueRayMovieList, wrongResult);
        assertEquals(blueRayMovieList.size(), result.size());
        assertEquals(0, wrongResult.size());
    }
}
