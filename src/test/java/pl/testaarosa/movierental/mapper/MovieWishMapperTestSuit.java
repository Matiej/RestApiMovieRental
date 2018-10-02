package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.repositories.MockMovieWish;
import pl.testaarosa.movierental.repositories.MockMovieWishDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieWishMapperTestSuit {

    @InjectMocks
    private MovieWishMapper movieWishMapper;

    private MockMovieWish mockMovieWish = new MockMovieWish();
    private List<MovieWish> movieWishList;
    private MockMovieWishDto mockMovieWishDto = new MockMovieWishDto();
    private List<MovieWishDto> movieWishDtoList;

    @Before
    public void init() {
        movieWishDtoList = mockMovieWishDto.mockMovieWishDtos();
        movieWishList = mockMovieWish.mockMovieWish();
    }

    @Test
    public void shouldMapToMovieWishDto1() {
        //given
        MovieWish movieWish = movieWishList.get(0);
        MovieWishDto movieWishDto = mockMovieWishDto.mockMovieWishDtos().get(0);
        //when
        MovieWishDto result = movieWishMapper.mapToMovieWishDto(movieWish);
        //then
        assertEquals(movieWishDto,result);
        assertEquals(movieWishDto.getWishName(), result.getWishName());
    }

    @Test
    public void shouldMapToMovieWishDto2() {
        //given
        MovieWish movieWish = movieWishList.get(1);
        MovieWishDto movieWishDto = mockMovieWishDto.mockMovieWishDtos().get(1);
        //when
        MovieWishDto result = movieWishMapper.mapToMovieWishDto(movieWish);
        //then
        assertEquals(movieWishDto,result);
        assertEquals(movieWishDto.getWishName(), result.getWishName());
    }

    @Test
    public void shouldNotMapToMovieWishDto() {
        //given
        MovieWish movieWish = movieWishList.get(0);
        MovieWishDto movieWishDto = mockMovieWishDto.mockMovieWishDtos().get(1);
        //when
        MovieWishDto result = movieWishMapper.mapToMovieWishDto(movieWish);
        //then
        assertNotEquals(movieWishDto,result);
        assertNotEquals(movieWishDto.getWishName(), result.getWishName());
    }

    @Test
    public void shouldMapToMovieWishDtoList() {
        //given
        movieWishDtoList.remove(2);
        //when
        List<MovieWishDto> resultList = movieWishMapper.mapToMovieWishDtoList(movieWishList);
        //then
        assertEquals(movieWishDtoList,resultList);
        assertEquals(2, resultList.size());
        assertNotEquals(1, resultList.size());
    }

    @Test
    public void shouldNotMapToMovieWishDtoList() {
        //given
        List<MovieWishDto> movieWishDtoList1 = movieWishDtoList;
//        movieWishDtoList1.remove(0);
        //when
        List<MovieWishDto> result = movieWishMapper.mapToMovieWishDtoList(movieWishList);
        //then
        assertNotEquals(movieWishDtoList1,result);
        assertEquals(2,result.size());
        assertNotEquals(movieWishDtoList1.size(), result.size());
    }


}
