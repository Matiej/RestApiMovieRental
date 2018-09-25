package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.repositories.MockUserMovie;
import pl.testaarosa.movierental.repositories.MockUserMovieDto;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserMovieMapperTestSuit {

    @InjectMocks
    private UserMovieMapper userMovieMapper;

    private MockUserMovie mockUserMovie = new MockUserMovie();
    private List<UserMovie> userMovieList;
    private MockUserMovieDto mockUserMovieDto = new MockUserMovieDto();
    private List<UserMovieDto> userMovieDtoList;

    @Before
    public void init() {
        userMovieDtoList = mockUserMovieDto.mockUserMovieList();
        userMovieList = mockUserMovie.userMovieList();
    }

    @Test
    public void shouldMapToUserMovieDtoList() {
        //given
        //then
        List<UserMovieDto> result = userMovieMapper.mapToUserMovieDtoList(userMovieList);
        //then
        assertEquals(userMovieDtoList,result);
        assertEquals(userMovieDtoList.size(),result.size());
        assertNotNull(result);
    }

    @Test
    public void shouldNotMapToUserMovieDtoList() {
        //given
        userMovieDtoList.remove(0);
        //then
        List<UserMovieDto> result = userMovieMapper.mapToUserMovieDtoList(userMovieList);
        //then
        assertNotEquals(userMovieDtoList,result);
        assertNotEquals(userMovieDtoList.size(),result.size());
        assertNotNull(result);
    }

    @Test
    public void shcouldMapToUserMovieDto1() {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        UserMovie userMovie = userMovieList.get(0);
        //when
        UserMovieDto result = userMovieMapper.mapToUserMovieDto(userMovie);
        //then
        assertEquals(userMovieDto,result);
        assertNotNull(result);
    }

    @Test
    public void shcouldMapToUserMovieDto2() {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(1);
        UserMovie userMovie = userMovieList.get(1);
        //when
        UserMovieDto result = userMovieMapper.mapToUserMovieDto(userMovie);
        //then
        assertEquals(userMovieDto,result);
        assertNotNull(result);
    }

    @Test
    public void shcouldNotMapToUserMovieDto() {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        UserMovie userMovie = userMovieList.get(0);
        userMovieDto.setImdbID("xxxxxxxxx");
        //when
        UserMovieDto result = userMovieMapper.mapToUserMovieDto(userMovie);
        //then
        assertNotEquals(userMovieDto,result);
        assertNotNull(result);
    }
}
