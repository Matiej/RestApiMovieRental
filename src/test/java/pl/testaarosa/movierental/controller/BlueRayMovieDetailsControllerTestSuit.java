package pl.testaarosa.movierental.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(BlueRayMovieDetailsController.class)
@WebAppConfiguration
public class BlueRayMovieDetailsControllerTestSuit {

    @InjectMocks
    private BlueRayMovieDetailsController blueRayMovieDetailsController;

    @Mock
    private MoviesFacade moviesFacade;

    private MockBlueRayMovieDto mockBlueRayMovieDto = new MockBlueRayMovieDto();
    private List<BlueRayMovieDto> blueRayMovieDtoList;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(blueRayMovieDetailsController).build();
        blueRayMovieDtoList = mockBlueRayMovieDto.blueRayMovieDto();
    }

    @Test
    public void testMovieDetail() throws Exception {
        //given
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(0);
        when(moviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/blueray/showmovie")
                .param("id", String.valueOf(1L)))
                .andExpect(model().attribute("movieDetail", blueRayMovieDto))
                .andExpect(view().name("blueRayMoviesDetails"));
        //then
        verify(moviesFacade, times(1)).findBlueRaById(1L);
        verifyNoMoreInteractions(moviesFacade);
    }
}
