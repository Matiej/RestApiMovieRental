package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class BlueRayMovieControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/blueray";
    private MockMvc mockMvc;
    private MockBlueRayMovieDto blueRayMovieDto;
    private List<BlueRayMovieDto> blueRayMovieDtoList;

    @InjectMocks
    private BlueRayMovieControllerRest blueRayMovieDetailsRest;

    @Mock
    private MoviesFacade bluRayMoviesFacade;

    @Before
    public void init() {
        blueRayMovieDto = new MockBlueRayMovieDto();
        blueRayMovieDtoList = blueRayMovieDto.blueRayMovieDto();
        mockMvc = standaloneSetup(blueRayMovieDetailsRest).build();
    }

    @Test
    public void shouldShowBlueRayMovies() throws Exception {
        //given
        when(bluRayMoviesFacade.findAllBlueRay()).thenReturn(blueRayMovieDtoList);
        //when
        String jsonContent = converter.jsonInString(blueRayMovieDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/movieslist"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(converter.jsonInString(blueRayMovieDtoList)));
        //then
        verify(bluRayMoviesFacade, times(1)).findAllBlueRay();
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }

    @Test
    public void shouldShowBlueRayMoviesStatus404() throws Exception {
        //given
        when(bluRayMoviesFacade.findAllBlueRay()).thenReturn(blueRayMovieDtoList);
        //when
        String jsonContent = converter.jsonInString(blueRayMovieDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/movieslist404"))
                .andExpect(status().is(404));
        //then
        verify(bluRayMoviesFacade, times(0)).findAllBlueRay();
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }

    @Test
    public void shouldShowSearchTitleResult() throws Exception {
        //given
        when(bluRayMoviesFacade.findAllBlueRayContainsTitle("Some title")).thenReturn(blueRayMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING+"/movieslistsearch")
                .param("title", "Some title"))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(blueRayMovieDtoList)));
        //then
        verify(bluRayMoviesFacade, times(1)).findAllBlueRayContainsTitle("Some title");
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }

    @Test
    public void shouldShowSearchTitleResultStatus404() throws Exception {
        //given
        when(bluRayMoviesFacade.findAllBlueRayContainsTitle("Some title")).thenReturn(blueRayMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING+"/movieslistsearchStatus404")
                .param("title", "Some title"))
                .andExpect(status().is(404));
        //then
        verify(bluRayMoviesFacade, times(0)).findAllBlueRayContainsTitle("Some title");
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }
}
