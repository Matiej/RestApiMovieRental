package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmdbBlueRayDetailsDto;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDetails;
import pl.testaarosa.movierental.repositories.MockOmdbBlueRayDetailsDto;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OmbdBlueRayDetailsMapperTestSuit {

    @InjectMocks
    private OmbdBlueRayDetailsMapper ombdBlueRayDetailsMapper;

    private MockOmdbBlueRayDetailsDto mockOmdbBlueRayDetailsDto = new MockOmdbBlueRayDetailsDto();
    private MockBlueRayMovieDetails mockBlueRayMovieDetails = new MockBlueRayMovieDetails();
    private List<BlueRayMovieDetails> blueRayMovieDetailsList;

    @Before
    public void init() {
        blueRayMovieDetailsList = mockBlueRayMovieDetails.blueRayMovieDetails();
    }

    @Test
    public void shouldMapToBlueRayMovieDetails() {
        //given
        BlueRayMovieDetails blueRayMovieDetails = blueRayMovieDetailsList.get(0);
        blueRayMovieDetails.setId(null);
        OmdbBlueRayDetailsDto omdbBlueRayDetailsDto = mockOmdbBlueRayDetailsDto.omdbBlueRayDetailsDto();
        //when
        BlueRayMovieDetails result = ombdBlueRayDetailsMapper.mapToBlueRayMovieDetails(omdbBlueRayDetailsDto);
        //then
        assertEquals(blueRayMovieDetails,result);
        assertEquals(blueRayMovieDetails.getActors(), result.getActors());
        assertEquals("HBO1", result.getProduction());
        assertNull(result.getId());
    }

    @Test
    public void shouldNotMapToBlueRayMovieDetails() {
        BlueRayMovieDetails blueRayMovieDetails = blueRayMovieDetailsList.get(1);
        OmdbBlueRayDetailsDto omdbBlueRayDetailsDto = mockOmdbBlueRayDetailsDto.omdbBlueRayDetailsDto();
        //when
        BlueRayMovieDetails result = ombdBlueRayDetailsMapper.mapToBlueRayMovieDetails(omdbBlueRayDetailsDto);
        //then
        assertNotEquals(blueRayMovieDetails,result);
        assertNotEquals(blueRayMovieDetails.getActors(), result.getActors());
        assertNotEquals("HBO2", result.getProduction());
    }
}
