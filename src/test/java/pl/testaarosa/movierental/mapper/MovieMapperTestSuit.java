package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.dto.MovieDto;
import pl.testaarosa.movierental.repositories.MockMovie;
import pl.testaarosa.movierental.repositories.MockMovieDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieMapperTestSuit {

    @InjectMocks
    private MovieMapper movieMapper;

    private MockMovieDto mockMovieDto = new MockMovieDto();
    private List<MovieDto> movieDtoList;
    private MockMovie mockMovie = new MockMovie();
    private List<Movie> movieList;

    @Before
    public void init() {
        movieDtoList = mockMovieDto.movieDtoList();
        movieList = mockMovie.movieDtoList();
    }

    @Test
    public void shouldMapToMovieDto0() {
        //given
        Movie movie = movieList.get(0);
        MovieDto movieDto = movieDtoList.get(0);
        //when
        MovieDto result = movieMapper.mapToMovieDto(movie);
        //then
        assertEquals(movieDto,result);
        assertEquals("Online TestTitle1", result.getTitle());
    }

    @Test
    public void shouldMapToMovieDto1() {
        //given
        Movie movie = movieList.get(1);
        MovieDto movieDto = movieDtoList.get(1);
        //when
        MovieDto result = movieMapper.mapToMovieDto(movie);
        //then
        assertEquals(movieDto,result);
        assertEquals("TestTitle1", result.getTitle());
    }

    @Test
    public void shouldNotMapToMovieDto() {
        //given
        Movie movie = movieList.get(1);
        MovieDto movieDto = movieDtoList.get(0);
        //when
        MovieDto result = movieMapper.mapToMovieDto(movie);
        //then
        assertNotEquals(movieDto, result);
        assertNotEquals("Online TestTitle1", result.getTitle());
    }

    @Test
    public void shouldtMapTOMovieDtoList() {
        //given
        movieDtoList.remove(3);
        //when
        List<MovieDto> result = movieMapper.mapTOMovieDtoList(movieList);
        //then
        assertEquals(movieDtoList,result);
        assertEquals(3, result.size());
    }

}
