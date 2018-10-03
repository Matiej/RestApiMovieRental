package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;
import pl.testaarosa.movierental.repositories.MockOneDvdDto;

import java.util.List;

public class OneDvdDtoTestSuit {

    private MockOneDvdDto mockOneDvdDto = new MockOneDvdDto();

    @Test
    public void testOneDvdDto() {
        //given
        List<OneDvdDto> oneDvdDtoList = mockOneDvdDto.oneDvdDtoList();
        OneDvdDto oneDvdDto1 = oneDvdDtoList.get(1);
        OneDvdDto oneDvdDto2 = oneDvdDtoList.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(oneDvdDto1,oneDvdDto2).testEquals();
    }
}
