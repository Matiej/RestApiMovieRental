package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDto;

import java.util.List;

public class BlueRayMovieDtoTestSuit {

    private MockBlueRayMovieDto mockBlueRayMovieDto = new MockBlueRayMovieDto();

    @Test
    public void testBlueRayMovieDetailsDto() {
        //given
        List<BlueRayMovieDto> blueRayMovieDtos = mockBlueRayMovieDto.blueRayMovieDto();
        BlueRayMovieDto blueRayMovieDto1 = blueRayMovieDtos.get(3);
        BlueRayMovieDto blueRayMovieDto2 = blueRayMovieDtos.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(blueRayMovieDto1, blueRayMovieDto2).testEquals();
    }
}
