package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.OmdbBlueRayPaginationDto;
import pl.testaarosa.movierental.repositories.MockOmdbBlueRayPaginationDto;

import java.util.List;

public class OmdbBlueRayPaginationDtoTestSuit {

    private MockOmdbBlueRayPaginationDto mockOmdbBlueRayPaginationDto = new MockOmdbBlueRayPaginationDto();

    @Test
    public void testOmdbBlueRayPaginationDtoTestSuit() {
        //given
        List<OmdbBlueRayPaginationDto> omdbBlueRayPaginationDtoList = mockOmdbBlueRayPaginationDto.omdbBlueRayPaginationDtos();
        OmdbBlueRayPaginationDto omdbBlueRayPaginationDto1 = omdbBlueRayPaginationDtoList.get(0);
        OmdbBlueRayPaginationDto omdbBlueRayPaginationDto2 = omdbBlueRayPaginationDtoList.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(omdbBlueRayPaginationDto1,omdbBlueRayPaginationDto2.toString());

    }

}
