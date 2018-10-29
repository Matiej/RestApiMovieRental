package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockDvdMovieDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class DvdMovieControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/dvd";
    private MockMvc mockMvc;
    private MockDvdMovieDto mockDvdMovieDto;
    private List<DvdMovieDto> dvdMovieDtoList;

    @InjectMocks
    private DvdMovieControllerRest dvdMovieControllerRest;

    @Mock
    private MoviesFacade dvdMoviesFacade;

    @Before
    public void init() {
        mockDvdMovieDto = new MockDvdMovieDto();
        dvdMovieDtoList = mockDvdMovieDto.dvdMovieDtoList();
        mockMvc = standaloneSetup(dvdMovieControllerRest).build();
    }

    @Test
    public void shouldshowDvdMoviesTest() throws Exception {
        //given
        when(dvdMoviesFacade.findAllDvd()).thenReturn(dvdMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING+"/movieslist"))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(dvdMovieDtoList)));
        //then
        verify(dvdMoviesFacade,times(1)).findAllDvd();
        verifyNoMoreInteractions(dvdMoviesFacade);
    }

    @Test
    public void shouldshowDvdMoviesStatus404() throws Exception {
        //given
        when(dvdMoviesFacade.findAllDvd()).thenReturn(dvdMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING+"/movieslistStatus400"))
                .andExpect(status().is(404));
        //then
        verify(dvdMoviesFacade,times(0)).findAllDvd();
        verifyNoMoreInteractions(dvdMoviesFacade);
    }

    @Test
    public void shouldShowSearchTitleResult() throws Exception {
        //given
        when(dvdMoviesFacade.findDvdByTitle("Dvd title")).thenReturn(dvdMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING+"/movieslistsearch")
        .param("title", "Dvd title"))
                .andExpect(status().is(200))
                .andExpect(content().json(converter.jsonInString(dvdMovieDtoList)));
        //then
        verify(dvdMoviesFacade, times(1)).findDvdByTitle("Dvd title");
        verifyNoMoreInteractions(dvdMoviesFacade);
    }

    @Test
    public void shouldShowSearchTitleResult404() throws Exception {
        //given
        when(dvdMoviesFacade.findDvdByTitle("Dvd title")).thenReturn(dvdMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING+"/msovieslistsearchStatus404")
                .param("title", "Dvd title"))
                .andExpect(status().is(404));
        //then
        verify(dvdMoviesFacade, times(0)).findDvdByTitle("Dvd title");
        verifyNoMoreInteractions(dvdMoviesFacade);
    }
}
