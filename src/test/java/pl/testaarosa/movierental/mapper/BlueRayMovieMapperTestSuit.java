package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.repositories.MockBlueRayMovie;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BlueRayMovieMapperTestSuit {

    private MockBlueRayMovieDto blueRayMovieDto = new MockBlueRayMovieDto();
    private List<BlueRayMovieDto> blueRayMovieDtoList = new ArrayList<>();
    private MockBlueRayMovie mockBlueRayMovie = new MockBlueRayMovie();
    private List<BlueRayMovie> blueRayMovieList = new ArrayList<>();
    private BlueRayMovieMapper blueRayMovieMapper = new BlueRayMovieMapper();

    @Before
    public void init() {
        blueRayMovieDtoList = blueRayMovieDto.blueRayMovieDto();
        blueRayMovieList = mockBlueRayMovie.blueRayMovieList();
    }

    @Test
    public void testMapToBlueRayMovie() {
        //given
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(0);
        BlueRayMovie blueRayMovie = blueRayMovieList.get(0);
        blueRayMovie.setBlueRayMovieDetails(null);
        blueRayMovie.setMovieWishList(new ArrayList<>());
        blueRayMovie.setId(null);
        //when
        BlueRayMovie result = blueRayMovieMapper.mapToBlueRayMovie(blueRayMovieDto);
        //then
        assertEquals(blueRayMovie,result);
    }

    @Test
    public void testMapToBlueRayMovieDto() {
        //given
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(1);
        BlueRayMovie blueRayMovie = blueRayMovieList.get(1);
        //when
        BlueRayMovieDto result = blueRayMovieMapper.mapToBlueRayMovieDto(blueRayMovie);
        //then
        assertEquals(blueRayMovieDto,result);
    }

    @Test
    public void testMapToBlueRayMovieDtoList() {
        //given
        //when
        List<BlueRayMovieDto> result = blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieList);
        //then
        assertEquals(blueRayMovieDtoList,result);
        assertEquals(3,result.size());
    }

}
