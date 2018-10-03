package pl.testaarosa.movierental.domain.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.repositories.MockMovieWishDto;

import java.util.List;

public class MovieWishDtoTestSuit {

    private MockMovieWishDto mockMovieWishDto = new MockMovieWishDto();

    @Test
    public void MovieWishDto() {
        //given
        List<MovieWishDto> movieWishDtoList = mockMovieWishDto.mockMovieWishDtos();
        MovieWishDto movieWishDto1 = movieWishDtoList.get(2);
        MovieWishDto movieWishDto2 = movieWishDtoList.get(1);
        //when
        //then
        new EqualsTester().addEqualityGroup(movieWishDto1,movieWishDto2).testEquals();
    }
}
