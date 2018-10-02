package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDetailsDto;
import pl.testaarosa.movierental.repositories.MockOmdbOnLineDetailsDto;

import java.util.List;

public class OmdbOnLineDetailsDtoTestSuit {

    private MockOmdbOnLineDetailsDto mockOmdbOnLineDetailsDto = new MockOmdbOnLineDetailsDto();

    @Test
    public void teestOmdbOnLineDetailsDto() {
        //given
        List<OmdbOnLineDetailsDto> omdbOnLineDetailsDtos = mockOmdbOnLineDetailsDto.omdbOnLineDetailsDtoList();
        OmdbOnLineDetailsDto omdbOnLineDetailsDto1 = omdbOnLineDetailsDtos.get(1);
        OmdbOnLineDetailsDto omdbOnLineDetailsDto2 = omdbOnLineDetailsDtos.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(omdbOnLineDetailsDto1,omdbOnLineDetailsDto2).testEquals();
    }
}
