package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.dto.OmdbBlueRayDto;
import pl.testaarosa.movierental.repositories.MockBlueRayMovie;
import pl.testaarosa.movierental.repositories.MockOmdbBlueRayDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class OmbdBlueRayMapperTestSuit {

    @InjectMocks
    private OmbdBlueRayMapper ombdBlueRayMapper;

    private MockOmdbBlueRayDto mockOmdbBlueRayDto = new MockOmdbBlueRayDto();
    private List<OmdbBlueRayDto> omdbBlueRayDtoList;
    private MockBlueRayMovie mockBlueRayMovie = new MockBlueRayMovie();
    private List<BlueRayMovie> blueRayMovieList;

    @Before
    public void init() {
        blueRayMovieList = mockBlueRayMovie.blueRayMovieList();
        omdbBlueRayDtoList = mockOmdbBlueRayDto.omdbBlueRayDto();
    }

    @Test
    public void shouldMapToBlueRayMoviesList() {
        //given
        blueRayMovieList.forEach(t-> {
                    t.setId(null);
                    t.setMovieWishList(new ArrayList<>());
                });
        //when
        List<BlueRayMovie> result = ombdBlueRayMapper.mapToBlueRayMoviesList(omdbBlueRayDtoList);
        //then
        assertEquals(blueRayMovieList,result);
        assertEquals(3,result.size());
    }

    @Test
    public void shouldNotMapToBlueRayMoviesList() {
        //given
        blueRayMovieList.forEach(t-> {
            t.setId(null);
            t.setMovieWishList(new ArrayList<>());
        });
        blueRayMovieList.remove(0);
        //when
        List<BlueRayMovie> result = ombdBlueRayMapper.mapToBlueRayMoviesList(omdbBlueRayDtoList);
        //then
        assertNotEquals(blueRayMovieList,result);
        assertEquals(3,result.size());
        assertNotEquals(blueRayMovieList.size(),result.size());
    }
}
