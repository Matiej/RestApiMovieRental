package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;
import pl.testaarosa.movierental.repositories.MockDvdMovie;
import pl.testaarosa.movierental.repositories.MockOneDvdDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class OneDvdMapperTestSuit {

    @InjectMocks
    private OneDvdMapper oneDvdMapper;

    private MockDvdMovie mockDvdMovie = new MockDvdMovie();
    private List<DvdMovie> dvdMovieList;
    private MockOneDvdDto mockOneDvdDto = new MockOneDvdDto();
    private List<OneDvdDto> oneDvdDtoList;

    @Before
    public void init() {
        dvdMovieList = mockDvdMovie.dvdMovieList();
        oneDvdDtoList = mockOneDvdDto.oneDvdDtoList();
    }

    @Test
    public void shouldMapToDvdMovie1() {
        //given
        OneDvdDto oneDvdDto = oneDvdDtoList.get(0);
        DvdMovie dvdMovie = dvdMovieList.get(0);
        dvdMovie.setDvdMovieDetails(null);
        dvdMovie.setMovieWishList(new ArrayList<>());
        //when
        DvdMovie result = oneDvdMapper.mapToDvdMovie(oneDvdDto);
        //then
        assertEquals(dvdMovie,result);
    }

    @Test
    public void shouldMapToDvdMovie2() {
        //given
        OneDvdDto oneDvdDto = oneDvdDtoList.get(1);
        DvdMovie dvdMovie = dvdMovieList.get(1);
        dvdMovie.setDvdMovieDetails(null);
        dvdMovie.setMovieWishList(new ArrayList<>());
        //when
        DvdMovie result = oneDvdMapper.mapToDvdMovie(oneDvdDto);
        //then
        assertEquals(dvdMovie,result);
    }

    @Test
    public void shouldNotMapToDvdMovie() {
        //given
        OneDvdDto oneDvdDto = oneDvdDtoList.get(1);
        DvdMovie dvdMovie = dvdMovieList.get(0);
        dvdMovie.setDvdMovieDetails(null);
        dvdMovie.setMovieWishList(new ArrayList<>());
        //when
        DvdMovie result = oneDvdMapper.mapToDvdMovie(oneDvdDto);
        //then
        assertNotEquals(dvdMovie,result);
    }
}
