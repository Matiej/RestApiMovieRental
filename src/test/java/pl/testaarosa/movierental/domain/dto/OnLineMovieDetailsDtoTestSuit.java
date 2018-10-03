package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetailsDto;

import java.util.List;

public class OnLineMovieDetailsDtoTestSuit {

    private MockOnLineMovieDetailsDto mockOnLineMovieDetailsDto = new MockOnLineMovieDetailsDto();

    @Test
    public void testOnLineMovieDetailsDto() {
        //given
        List<OnLineMovieDetailsDto> onLineMovieDetailsDtos = mockOnLineMovieDetailsDto.onLineMovieDetailsDtos();
        OnLineMovieDetailsDto onLineMovieDetailsDto1 = onLineMovieDetailsDtos.get(1);
        OnLineMovieDetailsDto onLineMovieDetailsDto2 = onLineMovieDetailsDtos.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(onLineMovieDetailsDto1,onLineMovieDetailsDto2).testEquals();
    }
}
