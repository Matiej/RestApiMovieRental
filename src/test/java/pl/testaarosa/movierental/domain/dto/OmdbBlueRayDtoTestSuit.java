package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.OmdbBlueRayDto;
import pl.testaarosa.movierental.repositories.MockOmdbBlueRayDto;

import java.util.List;

public class OmdbBlueRayDtoTestSuit {

    MockOmdbBlueRayDto mockOmdbBlueRayDto = new MockOmdbBlueRayDto();

    @Test
    public void testOmdbBlueRayDto() {
        //given
        List<OmdbBlueRayDto> omdbBlueRayDtoList = mockOmdbBlueRayDto.omdbBlueRayDto();
        OmdbBlueRayDto omdbBlueRayDto1 = omdbBlueRayDtoList.get(3);
        OmdbBlueRayDto omdbBlueRayDto2 = omdbBlueRayDtoList.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(omdbBlueRayDto1, omdbBlueRayDto2).testEquals();
    }
}
