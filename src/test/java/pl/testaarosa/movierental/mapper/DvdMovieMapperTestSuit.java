package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.repositories.MockDvdMovie;
import pl.testaarosa.movierental.repositories.MockDvdMovieDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DvdMovieMapperTestSuit {

    private MockDvdMovieDto mockDvdMovieDto = new MockDvdMovieDto();
    private List<DvdMovieDto> dvdMovieDtoList = new ArrayList<>();
    private MockDvdMovie mockDvdMovie = new MockDvdMovie();
    private List<DvdMovie> dvdMovieList = new ArrayList<>();
    private DvdMovieMapper movieMapper = new DvdMovieMapper();

    @Before
    public void init() {
        dvdMovieList = mockDvdMovie.dvdMovieList();
        dvdMovieDtoList = mockDvdMovieDto.dvdMovieDtoList();
    }

    @Test
    public void testMapToDvdMovieDto() {
        //given
        DvdMovie dvdMovie = dvdMovieList.get(0);
        DvdMovieDto dvdMovieDto = dvdMovieDtoList.get(0);
        //when
        DvdMovieDto result = movieMapper.mapToDvdMovieDto(dvdMovie);
        //then
        assertEquals(dvdMovieDto,result);
        assertTrue(result.getId()==1L);
    }

    @Test
    public void testMapToDvdDtoList() {
        //given
        //when
        List<DvdMovieDto> result = movieMapper.mapToDvdDtoList(dvdMovieList);
        //then
        assertEquals(dvdMovieDtoList,result);
        assertEquals(2, result.size());
    }
}
