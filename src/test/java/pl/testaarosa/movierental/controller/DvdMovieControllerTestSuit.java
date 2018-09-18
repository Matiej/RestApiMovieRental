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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(DvdMovieController.class)
@WebAppConfiguration
public class DvdMovieControllerTestSuit {

    @InjectMocks
    private DvdMovieController dvdMovieController;

    @Mock
    private MoviesFacade dvdMoviesFacade;

    private MockDvdMovieDto mockDvdMovieDto = new MockDvdMovieDto();
    private List<DvdMovieDto> dvdMovieDtoList = new ArrayList<>();
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(dvdMovieController).build();
        dvdMovieDtoList = mockDvdMovieDto.dvdMovieDtoList();
    }

    @Test
    public void testShowDvdMovies() throws Exception {
        //given
        when(dvdMoviesFacade.findAllDvd()).thenReturn(dvdMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/one/movieslist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("dvdMoviesFromSuppliers", dvdMovieDtoList))
                .andExpect(view().name("dvdMoviesList"));
        //then
        verify(dvdMoviesFacade, times(1)).findAllDvd();
        verifyNoMoreInteractions(dvdMoviesFacade);
    }

    @Test
    public void TestShowSearchTitleResult() throws Exception {
        //given
        when(dvdMoviesFacade.findDvdByTitle("DvdMovie1")).thenReturn(dvdMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/one/movieslistsearch")
                .param("title", "DvdMovie1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("searchresult", dvdMovieDtoList))
                .andExpect(view().name("dvdMovieSearchResult"));
        //then
        verify(dvdMoviesFacade, times(1)).findDvdByTitle("DvdMovie1");
        verifyNoMoreInteractions(dvdMoviesFacade);
    }
}
