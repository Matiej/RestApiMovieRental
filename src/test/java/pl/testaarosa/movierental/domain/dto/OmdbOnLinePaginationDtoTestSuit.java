package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.OmdbOnLinePaginationDto;
import pl.testaarosa.movierental.repositories.MockOmdbOnLinePaginationDto;

import java.util.List;

public class OmdbOnLinePaginationDtoTestSuit {

    private MockOmdbOnLinePaginationDto mockOmdbOnLinePaginationDto = new MockOmdbOnLinePaginationDto();

    @Test
    public void testOmdbOnLinePaginationDto() {
        //given
        List<OmdbOnLinePaginationDto> omdbOnLinePaginationDtoList = mockOmdbOnLinePaginationDto.omdbOnLinePaginationDto();
        OmdbOnLinePaginationDto omdbOnLinePaginationDto1 = omdbOnLinePaginationDtoList.get(0);
        OmdbOnLinePaginationDto omdbOnLinePaginationDto2 = omdbOnLinePaginationDtoList.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(omdbOnLinePaginationDto1,omdbOnLinePaginationDto2).testEquals();
    }
}
