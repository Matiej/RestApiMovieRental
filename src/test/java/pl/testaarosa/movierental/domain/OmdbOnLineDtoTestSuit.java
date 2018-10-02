package pl.testaarosa.movierental.domain;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDto;
import pl.testaarosa.movierental.repositories.MockOmdbOnLineDto;

import java.util.List;

public class OmdbOnLineDtoTestSuit {

    private MockOmdbOnLineDto mockOmdbOnLineDto = new MockOmdbOnLineDto();

    @Test
    public void testOmdbOnLineDto() {
        //given
        List<OmdbOnLineDto> omdbOnLineDtoList = mockOmdbOnLineDto.omdbOnLineDtoList();
        OmdbOnLineDto omdbOnLineDto1 = omdbOnLineDtoList.get(2);
        OmdbOnLineDto omdbOnLineDto2 = omdbOnLineDtoList.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(omdbOnLineDto1,omdbOnLineDto2).testEquals();
    }
}
