package pl.testaarosa.movierental.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.repositories.MockDvdMovie;
import pl.testaarosa.movierental.repositories.MockDvdMovieDto;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class DvdMovieMapperTestSuit {

    @InjectMocks
    private DvdMovieMapper movieMapper;

    private MockDvdMovieDto mockDvdMovieDto = new MockDvdMovieDto();
    private List<DvdMovieDto> dvdMovieDtoList;
    private MockDvdMovie mockDvdMovie = new MockDvdMovie();
    private List<DvdMovie> dvdMovieList;

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
        dvdMovie.setId(null);
        //when
        DvdMovieDto result = movieMapper.mapToDvdMovieDto(dvdMovie);
        //then
        assertEquals(dvdMovieDto,result);
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
