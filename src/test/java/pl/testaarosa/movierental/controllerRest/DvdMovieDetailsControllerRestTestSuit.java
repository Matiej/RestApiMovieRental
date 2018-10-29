package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockDvdMovieDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class DvdMovieDetailsControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/dvd";
    private MockMvc mockMvc;
    private MockDvdMovieDto mockDvdMovieDto;
    private List<DvdMovieDto> dvdMovieDtoList;

    @InjectMocks
    private DvdMovieDetailsControllerRest dvdMovieDetailsControllerRest;

    @Mock
    private MoviesFacade dvdMoviesFacade;

    @Before
    public void init() {
        mockMvc = standaloneSetup(dvdMovieDetailsControllerRest).build();
        mockDvdMovieDto = new MockDvdMovieDto();
        dvdMovieDtoList = mockDvdMovieDto.dvdMovieDtoList();
    }

    @Test
    public void shouldMovieDetail() throws Exception {
        //given
        DvdMovieDto expect = dvdMovieDtoList.get(0);
        when(dvdMoviesFacade.findDvdById(1L)).thenReturn(expect);
        //when
        mockMvc.perform(get(MAPPING+"/dvdetail")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(expect)));
        //then
        verify(dvdMoviesFacade,times(1)).findDvdById(1L);
        verifyNoMoreInteractions(dvdMoviesFacade);
    }

    @Test
    public void shouldMovieDetailStatus404() throws Exception {
        //given
        DvdMovieDto expect = dvdMovieDtoList.get(0);
        when(dvdMoviesFacade.findDvdById(1L)).thenReturn(expect);
        //when
        mockMvc.perform(get(MAPPING+"/dvdetailStatus404")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(404));
        //then
        verify(dvdMoviesFacade,times(0)).findDvdById(1L);
        verifyNoMoreInteractions(dvdMoviesFacade);
    }

    @Test
    public void shouldMovieDetailStatus400() throws Exception {
        //given
        DvdMovieDto expect = dvdMovieDtoList.get(0);
        when(dvdMoviesFacade.findDvdById(1L)).thenThrow(new MovieNotFoundException("ERROR"));
        //when
        mockMvc.perform(get(MAPPING+"/dvdetail")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(400));
        //then
        verify(dvdMoviesFacade,times(1)).findDvdById(1L);
        verifyNoMoreInteractions(dvdMoviesFacade);
    }
}
