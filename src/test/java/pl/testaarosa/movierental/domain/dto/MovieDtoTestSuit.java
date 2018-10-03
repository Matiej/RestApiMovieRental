package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockMovieDto;

import java.util.List;

public class MovieDtoTestSuit {

    private MockMovieDto mockMovieDto = new MockMovieDto();

    @Test
    public void testMovieDto() {
        //given
        List<MovieDto> movieDtoList = mockMovieDto.movieDtoList();
        MovieDto movieDto1 = movieDtoList.get(3);
        MovieDto movieDto2 = movieDtoList.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(movieDto1,movieDto2).testEquals();
    }
}
