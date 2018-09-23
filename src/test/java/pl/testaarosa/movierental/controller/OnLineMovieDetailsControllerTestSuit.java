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
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetailsDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(OnLineMovieDetailsController.class)
@WebAppConfiguration
public class OnLineMovieDetailsControllerTestSuit {

    @InjectMocks
    private OnLineMovieDetailsController OnLineMovieDetailsController;

    @Mock
    private MoviesFacade onLineMovieFacade;

    private MockMvc mockMvc;
    private MockOnLineMovieDetailsDto mockOnLineMovieDetailsDto = new MockOnLineMovieDetailsDto();
    private List<OnLineMovieDetailsDto> onLineMovieDetailsList;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(OnLineMovieDetailsController).build();
        onLineMovieDetailsList = mockOnLineMovieDetailsDto.onLineMovieDetailsDtos();
    }

    @Test
    public void testOnLineMovieDetail() throws Exception {
        //given
        OnLineMovieDetailsDto onLineMovieDetailsDto = onLineMovieDetailsList.get(1);
        when(onLineMovieFacade.getOnLineMovieDetails("imdbID_O2")).thenReturn(onLineMovieDetailsDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online//onlinedetail")
                .param("imdbID", "imdbID_O2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("onLineMovieDetails", onLineMovieDetailsDto))
                .andExpect(view().name("onLineMovieDetails"));
        OnLineMovieDetailsDto result = onLineMovieFacade.getOnLineMovieDetails("imdbID_O2");
        //then
        verify(onLineMovieFacade,times(2)).getOnLineMovieDetails("imdbID_O2");
        verifyZeroInteractions(onLineMovieFacade);
        assertEquals(onLineMovieDetailsDto,result);
    }

    @Test
    public void testOnLineMovieDetail_N() throws Exception {
        //given
        OnLineMovieDetailsDto onLineMovieDetailsDto = onLineMovieDetailsList.get(1);
        when(onLineMovieFacade.getOnLineMovieDetails("imdbID_O2")).thenReturn(onLineMovieDetailsDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online//onlinedetail_n")
                .param("imdbID", "imdbID_O2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("onLineMovieDetails", onLineMovieDetailsDto))
                .andExpect(view().name("onLineMovieDetails_n"));
        OnLineMovieDetailsDto result = onLineMovieFacade.getOnLineMovieDetails("imdbID_O2");
        //then
        verify(onLineMovieFacade,times(2)).getOnLineMovieDetails("imdbID_O2");
        verifyZeroInteractions(onLineMovieFacade);
        assertEquals(onLineMovieDetailsDto,result);
    }

}
