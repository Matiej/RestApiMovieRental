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
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.MockDvdMovieDto;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(DvdMovieDetailsController.class)
@WebAppConfiguration
public class DvdMovieDetailsControllerTestSuit {

    @InjectMocks
    private DvdMovieDetailsController dvdMovieDetailsController;

    @Mock
    private MoviesFacade dvdMoviesFacade;

    private MockDvdMovieDto mockDvdMovieDto = new MockDvdMovieDto();
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(dvdMovieDetailsController).build();
    }

    @Test
    public void testMovieDetail() throws Exception {
        //given
        DvdMovieDto dvdMovieDto = mockDvdMovieDto.dvdMovieDtoList().get(0);
        when(dvdMoviesFacade.findDvdById(1L)).thenReturn(dvdMovieDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/one/showmovie")
                .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("dvdMovieDetail", dvdMovieDto))
                .andExpect(view().name("dvdMovieDetails"));
        //then
        verify(dvdMoviesFacade, times(1)).findDvdById(1L);
        verifyNoMoreInteractions(dvdMoviesFacade);
    }
}
