package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class OnLineMovieDtoTestSuit {

    private MockOnLineMovieDto mockOnLineMovieDto = new MockOnLineMovieDto();

    @Test
    public void testOnLineMovieDto() throws ExecutionException, InterruptedException {
        //given
        List<OnLineMovieDto> onLineMovieDtos = mockOnLineMovieDto.onLineMovieDtoList();
        OnLineMovieDto onLineMovieDto1 = onLineMovieDtos.get(1);
        OnLineMovieDto onLineMovieDto2 = onLineMovieDtos.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(onLineMovieDto1,onLineMovieDto2).testEquals();
    }
}
