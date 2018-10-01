package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.OmdbBlueRayDetailsDto;
import pl.testaarosa.movierental.repositories.MockOmdbBlueRayDetailsDto;

public class OmdbBlueRayDetailsDtoTestSuit {

    private MockOmdbBlueRayDetailsDto mockOmdbBlueRayDetailsDto = new MockOmdbBlueRayDetailsDto();

    @Test
    public void testOmdbBlueRayDetailsDto() {
        //given
        OmdbBlueRayDetailsDto omdbBlueRayDetailsDto1 = mockOmdbBlueRayDetailsDto.omdbBlueRayDetailsDto();
        OmdbBlueRayDetailsDto omdbBlueRayDetailsDto2 = mockOmdbBlueRayDetailsDto.omdbBlueRayDetailsDtoEqualsTest();
        //when
        //then
        new EqualsTester().addEqualityGroup(omdbBlueRayDetailsDto1,omdbBlueRayDetailsDto2).testEquals();
    }
}
