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
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.MockOnLineMovie;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(OnLineMovieController.class)
@WebAppConfiguration
public class OnLineMovieControllerTestSuit {

    @InjectMocks
    private OnLineMovieController onLineMovieController;

    @Mock
    private MoviesFacade onLineMovieFacade;

    private MockMvc mockMvc;
    private MockOnLineMovie mockOnLineMovie = new MockOnLineMovie();
    private CompletableFuture<List<OnLineMovie>> onLineMovies = new CompletableFuture<>();
    private MockOnLineMovieDto mockOnLineMovieDto = new MockOnLineMovieDto();
    private List<OnLineMovieDto> onLineMovieDtoList;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        mockMvc = MockMvcBuilders.standaloneSetup(onLineMovieController).build();
        onLineMovies = mockOnLineMovie.onLineMovieList();
        onLineMovieDtoList = mockOnLineMovieDto.onLineMovieDtoList();
    }

    @Test
    public void shouldFindOnLineWhenNoTitleForLoggedUser() throws Exception {
        //given
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online/movielist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("onLineMovieHome"));
    }

    @Test
    public void shouldFindOnLineForLoggedUser() throws Exception {
        //given
        when(onLineMovieFacade.getOnLineMovies("Moj")).thenReturn(onLineMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online/movielist")
                .param("title", "Moj"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("onlinemovieslist", onLineMovieDtoList))
                .andExpect(view().name("onLineMoviesList"));
        List<OnLineMovieDto> res = onLineMovieFacade.getOnLineMovies("Moj");
        //then
        assertEquals(onLineMovieDtoList, res);
        verify(onLineMovieFacade, times(2)).getOnLineMovies("Moj");
        verifyNoMoreInteractions(onLineMovieFacade);
    }

    @Test
    public void shouldNotFindOnLineForLoggedUser() throws Exception {
        //given
        List<OnLineMovieDto> emptyOnLineMovieDtos = new ArrayList<>();
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online/movielist")
                .param("title", "Moj"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(model().attribute("onlinemovieslist",onLineMovieDtoList))
                .andExpect(view().name("onLineMoviesError"));
        List<OnLineMovieDto> res = onLineMovieFacade.getOnLineMovies("Moj");
        //then
        verify(onLineMovieFacade, times(2)).getOnLineMovies("Moj");
        verifyNoMoreInteractions(onLineMovieFacade);
    }

    @Test
    public void shouldFindOnLineWhenNoTitleForUnloggedUser() throws Exception {
        //given
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online/movielist_n"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("onLineMovieHome_n"));
    }
    @Test
    public void shouldFindOnLineForUnloggedUser() throws Exception {
        //given
        when(onLineMovieFacade.getOnLineMovies("Moj")).thenReturn(onLineMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online/movielist_n")
                .param("title", "Moj"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("onlinemovieslist", onLineMovieDtoList))
                .andExpect(view().name("onLineMoviesList_n"));
        List<OnLineMovieDto> res = onLineMovieFacade.getOnLineMovies("Moj");
        //then
        assertEquals(onLineMovieDtoList, res);
        verify(onLineMovieFacade, times(2)).getOnLineMovies("Moj");
        verifyNoMoreInteractions(onLineMovieFacade);
    }

    @Test
    public void shouldNotFindOnLineForUnloggedUser() throws Exception {
        //given
        List<OnLineMovieDto> emptyOnLineMovieDtos = new ArrayList<>();
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/online/movielist_n")
                .param("title", "Moj"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("onLineMoviesError_n"));
        List<OnLineMovieDto> res = onLineMovieFacade.getOnLineMovies("Moj");
        //then
        verify(onLineMovieFacade, times(2)).getOnLineMovies("Moj");
        verifyNoMoreInteractions(onLineMovieFacade);
    }
}
