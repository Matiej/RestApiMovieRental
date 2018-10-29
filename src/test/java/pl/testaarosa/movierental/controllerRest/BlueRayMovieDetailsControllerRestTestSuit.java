package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class BlueRayMovieDetailsControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/blueray";
    @InjectMocks
    private BlueRayMovieDetailsControllerRest blueRayMovieDetailsControllerRest;

    @Mock
    private MoviesFacade bluRayMoviesFacade;

    private MockMvc mockMvc;
    private MockBlueRayMovieDto blueRayMovieDto;
    private List<BlueRayMovieDto> blueRayMovieDtoList;

    @Before
    public void init() {
        blueRayMovieDto = new MockBlueRayMovieDto();
        blueRayMovieDtoList = blueRayMovieDto.blueRayMovieDto();
        mockMvc = standaloneSetup(blueRayMovieDetailsControllerRest).build();
    }

    @Test
    public void shouldFindMovieDetail1() throws Exception {
        //given
        when(bluRayMoviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDtoList.get(0));
        //when
        String jsonContent = converter.jsonInString(blueRayMovieDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/showmovie")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(converter.jsonInString(blueRayMovieDtoList.get(0))));
        //then
        verify(bluRayMoviesFacade, times(1)).findBlueRaById(1L);
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }

    @Test
    public void shouldFindMovieDetailStatus400() throws Exception {
        //given
        when(bluRayMoviesFacade.findBlueRaById(1L)).thenThrow(new MovieNotFoundException("ERROR"));
        //when
        String jsonContent = converter.jsonInString(blueRayMovieDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/showmovie")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(400));
        //then
        verify(bluRayMoviesFacade, times(1)).findBlueRaById(1L);
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }

    @Test
    public void shouldFindMovieDetailStatus404() throws Exception {
        //given
        when(bluRayMoviesFacade.findBlueRaById(1L)).thenReturn(null);
        //when
        String jsonContent = converter.jsonInString(blueRayMovieDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get(MAPPING + "/showmovie1111")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(404));
        //then
        verify(bluRayMoviesFacade, times(0)).findBlueRaById(1L);
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }
}
