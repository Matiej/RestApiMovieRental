package pl.testaarosa.movierental.facade;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.mapper.*;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDto;
import pl.testaarosa.movierental.services.BlueRayMovieService;
import pl.testaarosa.movierental.services.DvdMovieService;
import pl.testaarosa.movierental.services.MovieService;
import pl.testaarosa.movierental.services.OnLineMovieService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class MoviesFacadeTestSuit {

    @InjectMocks
    private MoviesFacade moviesFacade;

    @Mock
    private BlueRayMovieService blueRayMovieService;
    @Mock
    private BlueRayMovieMapper blueRayMovieMapper;
    @Mock
    private BlueRayMovieMapper blueMovieDetailsMapper;
    @Mock
    private DvdMovieService dvdMovieService;
    @Mock
    private DvdMovieMapper dvdMovieMapper;
    @Mock
    private OnLineMovieService onLineMovieService;
    @Mock
    private OnLineMovieMapper onLineMovieMapper;
    @Mock
    private OnLineMovieDetailsMapper detailsMapper;
    @Mock
    private MovieService movieService;
    @Mock
    private MovieMapper movieMapper;

    private MockBlueRayMovieDto mockBlueRayMovieDto = new MockBlueRayMovieDto();
    private List<BlueRayMovieDto> blueRayMovieDtoList;

    @Before
    public void init() {
        blueRayMovieDtoList = mockBlueRayMovieDto.blueRayMovieDto();
    }

    @Test
    public void testFindAllBlueRay() {
        //given
        when(moviesFacade.findAllBlueRay()).thenReturn(blueRayMovieDtoList);
        //when
        List<BlueRayMovieDto> result = moviesFacade.findAllBlueRay();
        //then
        assertEquals(blueRayMovieDtoList, result);
        assertEquals(4, result.size());
        assertEquals(blueRayMovieDtoList.get(0).getImdbID(), result.get(0).getImdbID());
    }

}
