package pl.testaarosa.movierental.facade;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.mapper.*;
import pl.testaarosa.movierental.repositories.*;
import pl.testaarosa.movierental.services.BlueRayMovieService;
import pl.testaarosa.movierental.services.DvdMovieService;
import pl.testaarosa.movierental.services.MovieService;
import pl.testaarosa.movierental.services.OnLineMovieService;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
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
    private MockDvdMovieDto mockDvdMovieDto = new MockDvdMovieDto();
    private List<DvdMovieDto> dvdMovieDtoList;
    private MockOnLineMovieDto mockOnLineMovieDto = new MockOnLineMovieDto();
    private List<OnLineMovieDto> onLineMovieDtoList;
    private MockOnLineMovieDetailsDto mockOnLineMovieDetailsDto = new MockOnLineMovieDetailsDto();
    private List<OnLineMovieDetailsDto> onLineMovieDetailsDtoList;
    private MockMovieDto mockMovieDto = new MockMovieDto();
    private List<MovieDto> movieDtoList;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        blueRayMovieDtoList = mockBlueRayMovieDto.blueRayMovieDto();
        dvdMovieDtoList = mockDvdMovieDto.dvdMovieDtoList();
        onLineMovieDtoList = mockOnLineMovieDto.onLineMovieDtoList();
        onLineMovieDetailsDtoList = mockOnLineMovieDetailsDto.onLineMovieDetailsDtos();
        movieDtoList = mockMovieDto.movieDtoList();
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

    @Test
    public void testFindAllBlueRayContainsTitle() {
        //given
        when(moviesFacade.findAllBlueRayContainsTitle("Title")).thenReturn(blueRayMovieDtoList);
        //when
        List<BlueRayMovieDto> result = moviesFacade.findAllBlueRayContainsTitle("Title");
        //then
        assertEquals(blueRayMovieDtoList, result);
        assertEquals(blueRayMovieDtoList.get(0).getImdbID(), result.get(0).getImdbID());
        assertEquals(4, result.size());
        assertNotNull(result);
    }

    @Test
    public void testFindBlueRaById() {
        //given
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(0);
        when(moviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDto);
        //when
        BlueRayMovieDto result = moviesFacade.findBlueRaById(1L);
        //then
        assertEquals(blueRayMovieDto, result);
        assertNotNull(result);
    }

    @Test
    public void testFindBlueRaByIdWrongResult() {
        //given
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(0);
        BlueRayMovieDto blueRayMovieDtoWrong = blueRayMovieDtoList.get(1);
        when(moviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDto);
        //when
        BlueRayMovieDto result = moviesFacade.findBlueRaById(1L);
        //then
        assertNotEquals(blueRayMovieDtoWrong, result);
        assertNotNull(result);
    }

    @Test
    public void testFindAllDvd() {
        //given
        when(moviesFacade.findAllDvd()).thenReturn(dvdMovieDtoList);
        //when
        List<DvdMovieDto> result = moviesFacade.findAllDvd();
        //then
        assertEquals(dvdMovieDtoList,result);
        assertNotNull(result);
    }

    @Test
    public void testFindDvdByIdSucces() {
        //given
        DvdMovieDto dvdMovieDto = dvdMovieDtoList.get(0);
        when(moviesFacade.findDvdById(1L)).thenReturn(dvdMovieDto);
        //when
        DvdMovieDto result = moviesFacade.findDvdById(1l);
        //then
        assertEquals(dvdMovieDto,result);
        assertNotNull(result);
    }


    @Test
    public void testFindDvdByIdWrong() {
        //given
        DvdMovieDto dvdMovieDto = dvdMovieDtoList.get(0);
        DvdMovieDto dvdMovieDtoWrong = dvdMovieDtoList.get(1);
        when(moviesFacade.findDvdById(1L)).thenReturn(dvdMovieDto);
        //when
        DvdMovieDto result = moviesFacade.findDvdById(1l);
        //then
        assertNotEquals(dvdMovieDtoWrong,result);
        assertNotNull(result);
    }

    @Test
    public void testFindDvdByTitleSucces() {
        //given
        when(moviesFacade.findDvdByTitle("TitleFVF")).thenReturn(dvdMovieDtoList);
        //when
        List<DvdMovieDto> result = moviesFacade.findDvdByTitle("TitleFVF");
        //then
        assertEquals(dvdMovieDtoList,result);
        assertNotNull(result);
    }

    @Test
    public void testFindDvdByTitleWrong() {
        //given
        when(moviesFacade.findDvdByTitle("TitleFVF")).thenReturn(dvdMovieDtoList);
        //when
        List<DvdMovieDto> result = moviesFacade.findDvdByTitle("TitleFVF");
        //then
        assertNotEquals(blueRayMovieDtoList,result);
        assertNotNull(result);
    }

    @Test
    public void testGetOnLineMoviesSucces() throws ExecutionException, InterruptedException {
        //given
        when(moviesFacade.getOnLineMovies("TitleFVF")).thenReturn(onLineMovieDtoList);
        //when
        List<OnLineMovieDto> result = moviesFacade.getOnLineMovies("TitleFVF");
        //then
        assertEquals(onLineMovieDtoList,result);
        assertNotNull(result);
    }

    @Test
    public void testGetOnLineMoviesWrong() throws ExecutionException, InterruptedException {
        //given
        when(moviesFacade.getOnLineMovies("TitleFVF")).thenReturn(onLineMovieDtoList);
        //when
        List<OnLineMovieDto> result = moviesFacade.getOnLineMovies("TitleFVF");
        //then
        assertNotEquals(blueRayMovieDtoList,result);
        assertNotNull(result);
    }

    @Test
    public void testGetOnLineMovieDetailsSuscces() throws ExecutionException, InterruptedException {
        //given
        OnLineMovieDetailsDto onLineMovieDetailsDto = onLineMovieDetailsDtoList.get(0);
        when(moviesFacade.getOnLineMovieDetails("IMDX")).thenReturn(onLineMovieDetailsDto);
        //then
        OnLineMovieDetailsDto result = moviesFacade.getOnLineMovieDetails("IMDX");
        //then
        assertEquals(onLineMovieDetailsDto, result);
        assertNotNull(result);
    }

    @Test
    public void testGetOnLineMovieDetailsWrong() throws ExecutionException, InterruptedException {
        //given
        OnLineMovieDetailsDto onLineMovieDetailsDto = onLineMovieDetailsDtoList.get(0);
        OnLineMovieDetailsDto onLineMovieDetailsDtoWrong = onLineMovieDetailsDtoList.get(1);
        when(moviesFacade.getOnLineMovieDetails("IMDX")).thenReturn(onLineMovieDetailsDto);
        //then
        OnLineMovieDetailsDto result = moviesFacade.getOnLineMovieDetails("IMDX");
        //then
        assertNotEquals(onLineMovieDetailsDtoWrong, result);
        assertNotNull(result);
    }

    @Test
    public void testFindOnLineByIdSucces() {
        //given
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        when(moviesFacade.findOnLineById(1L)).thenReturn(onLineMovieDto);
        //when
        OnLineMovieDto result = moviesFacade.findOnLineById(1L);
        //then
        assertNotNull(result);
        assertEquals(onLineMovieDto,result);
    }

    @Test
    public void testFindOnLineByIdWrong() {
        //given
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        OnLineMovieDto onLineMovieDtoWrong = onLineMovieDtoList.get(1);
        when(moviesFacade.findOnLineById(1L)).thenReturn(onLineMovieDto);
        //when
        OnLineMovieDto result = moviesFacade.findOnLineById(1L);
        //then
        assertNotNull(result);
        assertNotEquals(onLineMovieDtoWrong,result);
    }

    @Test
    public void testAddOnLineMovieToDbSucces() throws ExecutionException, InterruptedException {
        //given
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        when(moviesFacade.addOnLineMovieToDb("XIMA")).thenReturn(onLineMovieDto);
        //when
        OnLineMovieDto result = moviesFacade.addOnLineMovieToDb("XIMA");
        //then
        assertEquals(onLineMovieDto,result);
        assertNotNull(result);
    }

    @Test
    public void testAddOnLineMovieToDbWrong() throws ExecutionException, InterruptedException {
        //given
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        OnLineMovieDto onLineMovieDtoWrong = onLineMovieDtoList.get(1);
        when(moviesFacade.addOnLineMovieToDb("XIMA")).thenReturn(onLineMovieDto);
        //when
        OnLineMovieDto result = moviesFacade.addOnLineMovieToDb("XIMA");
        //then
        assertNotEquals(onLineMovieDtoWrong,result);
        assertNotNull(result);
    }

    @Test
    public void TestFindMovieByIdSucces() {
        //given
        MovieDto movieDto = movieDtoList.get(0);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        //when
        MovieDto result = moviesFacade.findMovieById(1L);
        //then
        assertNotNull(result);
        assertEquals(movieDto,result);
    }

    @Test
    public void TestFindMovieByIdWrong() {
        //given
        MovieDto movieDto = movieDtoList.get(0);
        MovieDto movieDtoWrong = movieDtoList.get(1);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        //when
        MovieDto result = moviesFacade.findMovieById(1L);
        //then
        assertNotNull(result);
        assertNotEquals(movieDtoWrong,result);
    }
}
