package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetails;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetailsDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class OnLineMovieDetailsMapperTestSuit {

    @InjectMocks
    private OnLineMovieDetailsMapper onLineMovieDetailsMapper;

    private MockOnLineMovieDetails mockOnLineMovieDetails = new MockOnLineMovieDetails();
    private List<OnLineMovieDetails> onLineMovieDetailsList;
    private MockOnLineMovieDetailsDto mockOnLineMovieDetailsDto = new MockOnLineMovieDetailsDto();
    private List<OnLineMovieDetailsDto> onLineMovieDetailsDtoList;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        onLineMovieDetailsList = mockOnLineMovieDetails.onLineMovieDetails().get();
        onLineMovieDetailsDtoList = mockOnLineMovieDetailsDto.onLineMovieDetailsDtos();
    }

    @Test
    public void shouldMapToOnLineDetalisDto1() {
        //given
        OnLineMovieDetailsDto onLineMovieDetailsDto = onLineMovieDetailsDtoList.get(0);
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(0);
        //when
        OnLineMovieDetailsDto result = onLineMovieDetailsMapper.mapToOnLineDetalisDto(onLineMovieDetails);
        //then
        assertEquals(onLineMovieDetailsDto,result);
    }

    @Test
    public void shouldMapToOnLineDetalisDto2() {
        //given
        OnLineMovieDetailsDto onLineMovieDetailsDto = onLineMovieDetailsDtoList.get(0);
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(0);
        //when
        OnLineMovieDetailsDto result = onLineMovieDetailsMapper.mapToOnLineDetalisDto(onLineMovieDetails);
        //then
        assertEquals(onLineMovieDetailsDto,result);
    }

    @Test
    public void shouldNotMapToOnLineDetalisDto() {
        //given
        OnLineMovieDetailsDto onLineMovieDetailsDto = onLineMovieDetailsDtoList.get(1);
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(0);
        //when
        OnLineMovieDetailsDto result = onLineMovieDetailsMapper.mapToOnLineDetalisDto(onLineMovieDetails);
        //then
        assertNotEquals(onLineMovieDetailsDto,result);
    }

}
