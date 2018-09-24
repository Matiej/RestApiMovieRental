package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.DvdMovieDetails;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;
import pl.testaarosa.movierental.repositories.MockDvdMovieDetails;
import pl.testaarosa.movierental.repositories.MockOneDvdDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class OneDvdDetilsMapperTestSuit {

    @InjectMocks
    private OneDvdDetilsMapper oneDvdDetilsMapper;

    private MockOneDvdDto mockOneDvdDto = new MockOneDvdDto();
    private List<OneDvdDto> oneDvdDtoList;
    private MockDvdMovieDetails mockDvdMovieDetails = new MockDvdMovieDetails();
    private List<DvdMovieDetails> dvdMovieDetailsList;

   @Before
   public void init() {
       oneDvdDtoList = mockOneDvdDto.oneDvdDtoList();
       dvdMovieDetailsList = mockDvdMovieDetails.dvdMovieDetailsList();
   }

   @Test
    public void shouldMatpToOneDvdDetails1() {
       //given
       OneDvdDto oneDvdDto = oneDvdDtoList.get(0);
       DvdMovieDetails dvdMovieDetails = dvdMovieDetailsList.get(0);
       //when
       DvdMovieDetails result = oneDvdDetilsMapper.matpToOneDvdDetails(oneDvdDto);
       //then
       assertEquals(dvdMovieDetails,result);
       assertEquals(dvdMovieDetails.getCountryOfOrigin(), result.getCountryOfOrigin());
   }

    @Test
    public void shouldMatpToOneDvdDetails2() {
        //given
        OneDvdDto oneDvdDto = oneDvdDtoList.get(1);
        DvdMovieDetails dvdMovieDetails = dvdMovieDetailsList.get(1);
        //when
        DvdMovieDetails result = oneDvdDetilsMapper.matpToOneDvdDetails(oneDvdDto);
        //then
        assertEquals(dvdMovieDetails,result);
        assertEquals(dvdMovieDetails.getCountryOfOrigin(), result.getCountryOfOrigin());
    }

    @Test
    public void shouldNotMatpToOneDvdDetails() {
        //given
        OneDvdDto oneDvdDto = oneDvdDtoList.get(0);
        DvdMovieDetails dvdMovieDetails = dvdMovieDetailsList.get(1);
        //when
        DvdMovieDetails result = oneDvdDetilsMapper.matpToOneDvdDetails(oneDvdDto);
        //then
        assertNotEquals(dvdMovieDetails,result);
        assertNotEquals(dvdMovieDetails.getCountryOfOrigin(), result.getCountryOfOrigin());
    }
}
