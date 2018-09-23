package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDetailsDto;
import pl.testaarosa.movierental.repositories.MockOmdbOnLineDetailsDto;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetails;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OmbdOneLineDetailsMapperTestSuit {

    @InjectMocks
    private OmbdOneLineDetailsMapper ombdOneLineDetailsMapper;

    private MockOnLineMovieDetails mockOnLineMovieDetails = new MockOnLineMovieDetails();
    private List<OnLineMovieDetails> onLineMovieDetailsList;
    private MockOmdbOnLineDetailsDto mockOmdbOnLineDetailsDto = new MockOmdbOnLineDetailsDto();
    private List<OmdbOnLineDetailsDto> omdbOnLineDetailsDtoList;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        omdbOnLineDetailsDtoList = mockOmdbOnLineDetailsDto.omdbOnLineDetailsDtoList();
        onLineMovieDetailsList = mockOnLineMovieDetails.onLineMovieDetails().get();
    }

    @Test
    public void shouldMapToOnLineMovieDetails1() {
        //given
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(0);
        OmdbOnLineDetailsDto omdbOnLineDetailsDto = omdbOnLineDetailsDtoList.get(0);
        //when
        OnLineMovieDetails result = ombdOneLineDetailsMapper.mapToOnLineMovieDetails(omdbOnLineDetailsDto);
        //then
        assertEquals(onLineMovieDetails, result);
        assertNotNull(result);
        assertEquals(onLineMovieDetails.getActors(), result.getActors());
    }

    @Test
    public void shouldMapToOnLineMovieDetails2() {
        //given
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(1);
        OmdbOnLineDetailsDto omdbOnLineDetailsDto = omdbOnLineDetailsDtoList.get(1);
        //when
        OnLineMovieDetails result = ombdOneLineDetailsMapper.mapToOnLineMovieDetails(omdbOnLineDetailsDto);
        //then
        assertEquals(onLineMovieDetails, result);
        assertNotNull(result);
        assertEquals(onLineMovieDetails.getActors(), result.getActors());
    }

    @Test
    public void shouldNotMapToOnLineMovieDetails1() {
        //given
        OnLineMovieDetails onLineMovieDetails = onLineMovieDetailsList.get(0);
        OmdbOnLineDetailsDto omdbOnLineDetailsDto = omdbOnLineDetailsDtoList.get(1);
        //when
        OnLineMovieDetails result = ombdOneLineDetailsMapper.mapToOnLineMovieDetails(omdbOnLineDetailsDto);
        //then
        assertNotEquals(onLineMovieDetails, result);
        assertNotNull(result);
        assertNotEquals("actor1", result.getActors());
    }
}
