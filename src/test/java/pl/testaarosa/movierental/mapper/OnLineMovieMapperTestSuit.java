package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.repositories.MockOnLineMovie;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OnLineMovieMapperTestSuit {

    @InjectMocks
    private OnLineMovieMapper onLineMovieMapper;

    private MockOnLineMovie mockOnLineMovie = new MockOnLineMovie();
    private List<OnLineMovie> onLineMovieList;
    private MockOnLineMovieDto mockOnLineMovieDto = new MockOnLineMovieDto();
    private List<OnLineMovieDto> onLineMovieDtoList;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        onLineMovieList = mockOnLineMovie.onLineMovieList().get();
        onLineMovieDtoList = mockOnLineMovieDto.onLineMovieDtoList();
    }

    @Test
    public void shouldMapToOnlineMovieDto1() {
        //given
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        OnLineMovie onLineMovie = onLineMovieList.get(0);
        //when
        OnLineMovieDto result = onLineMovieMapper.mapToOnlineMovieDto(onLineMovie);
        //then
        assertEquals(onLineMovieDto,result);
        assertNotNull(result);
    }

    @Test
    public void shouldMapToOnlineMovieDto2() {
        //given
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(1);
        OnLineMovie onLineMovie = onLineMovieList.get(1);
        //when
        OnLineMovieDto result = onLineMovieMapper.mapToOnlineMovieDto(onLineMovie);
        //then
        assertEquals(onLineMovieDto,result);
        assertNotNull(result);
    }

    @Test
    public void shouldNotMapToOnlineMovieDto2() {
        //given
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(1);
        OnLineMovie onLineMovie = onLineMovieList.get(0);
        //when
        OnLineMovieDto result = onLineMovieMapper.mapToOnlineMovieDto(onLineMovie);
        //then
        assertNotEquals(onLineMovieDto,result);
        assertNotNull(result);
    }

    @Test
    public void shouldMapToOnLineMovieDtoList() {
        //given
        //when
        List<OnLineMovieDto> result = onLineMovieMapper.mapToOnLineMovieDtoList(onLineMovieList);
        //then
        assertEquals(onLineMovieDtoList,result);
        assertEquals(2,result.size());
    }
}
