package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.repositories.MockUserMovieDto;

import java.util.List;

public class UserMovieDtoTestSuit {

    private MockUserMovieDto mockUserMovieDto = new MockUserMovieDto();

    @Test
    public void testUserMovieDto() {
        //given
        List<UserMovieDto> userMovieDtoList = mockUserMovieDto.mockUserMovieList();
        UserMovieDto userMovieDto1 = userMovieDtoList.get(1);
        UserMovieDto userMovieDto2 = userMovieDtoList.get(2);
        //when
        //then
        new EqualsTester().addEqualityGroup(userMovieDto1,userMovieDto2).testEquals();
    }
}
