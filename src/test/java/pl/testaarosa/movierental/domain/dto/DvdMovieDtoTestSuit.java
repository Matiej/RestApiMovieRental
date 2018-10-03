package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockDvdMovieDto;

import java.util.List;

public class DvdMovieDtoTestSuit {

    private MockDvdMovieDto mockDvdMovieDto = new MockDvdMovieDto();

    @Test
    public void testDvdMovieDto() {
        //given
        List<DvdMovieDto> dvdMovieDtos = mockDvdMovieDto.dvdMovieDtoList();
        DvdMovieDto dvdMovieDto1 = dvdMovieDtos.get(1);
        DvdMovieDto dvdMovieDto2 = dvdMovieDtos.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(dvdMovieDto1,dvdMovieDto2).testEquals();
    }
}
