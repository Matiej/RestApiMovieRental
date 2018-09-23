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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.MockBlueRayMovieDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(BlueRayMovieController.class)
@WebAppConfiguration
public class BlueRayMovieControllerTestSuit {

    @InjectMocks
    private BlueRayMovieController blueRayMovieController;

    @Mock
    private MoviesFacade bluRayMoviesFacade;

    private MockMvc mockMvc;
    private MockBlueRayMovieDto mockBlueRayMovieDto = new MockBlueRayMovieDto();
    private List<BlueRayMovieDto> blueRayMovieList;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(blueRayMovieController).build();
        blueRayMovieList = mockBlueRayMovieDto.blueRayMovieDto();
    }

    @Test
    public void testShowBlueRayMovies() throws Exception {
        //given
        when(bluRayMoviesFacade.findAllBlueRay()).thenReturn(blueRayMovieList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/blueray/movieslist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("blueRayMoviesFromSuppliers", blueRayMovieList))
                .andExpect(view().name("blueRayMoviesList"));
        //then
        verify(bluRayMoviesFacade, times(1)).findAllBlueRay();
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }

    @Test
    public void testShowSearchTitleResult() throws Exception {
        //given
        when(bluRayMoviesFacade.findAllBlueRayContainsTitle("TestTitle1")).thenReturn(blueRayMovieList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/blueray/movieslistsearch")
                .param("title", "TestTitle1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("searchresult", blueRayMovieList))
                .andExpect(view().name("blueRayMovieSearchResult"));
        //then
        verify(bluRayMoviesFacade, times(1)).findAllBlueRayContainsTitle("TestTitle1");
        verifyNoMoreInteractions(bluRayMoviesFacade);
    }
}
