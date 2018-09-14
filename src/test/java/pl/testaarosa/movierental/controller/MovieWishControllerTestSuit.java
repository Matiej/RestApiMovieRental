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
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.repositories.MockMovieWishDto;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(MovieWishController.class)
@WebAppConfiguration
public class MovieWishControllerTestSuit {

    @InjectMocks
    private MovieWishController movieWishController;

    @Mock
    private UserFacade userFacade;
    @Mock
    private MoviesFacade moviesFacade;

    private MockMvc mockMvc;
    private MockMovieWishDto mockMovieWishDto = new MockMovieWishDto();
    private List<MovieWishDto> movieWishDtos = new ArrayList<>();
    private MockOnLineMovieDto mockOnLineMovieDto = new MockOnLineMovieDto();
    private List<OnLineMovieDto> onLineMovieDtoList = new ArrayList<>();

    @Before
    public void init() throws ExecutionException, InterruptedException {
        mockMvc = MockMvcBuilders.standaloneSetup(movieWishController).build();
        movieWishDtos = mockMovieWishDto.mockMovieWishDtos();
        onLineMovieDtoList = mockOnLineMovieDto.onLineMovieDtoList();
    }

    @Test
    public void testAddMovieToWishList() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtos.get(0);
        when(userFacade.addMovie(null, 1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(null)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/addmovie")
                .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("userWishes", movieWishDto))
                .andExpect(view().name("movieUserWishes"));
        //then
        verify(userFacade,times(1)).findUsersWishForGivenUser(null);
        verify(userFacade,times(1)).addMovie(null, 1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testAddOnlineMovieToWishList() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtos.get(0);
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        when(moviesFacade.addOnLineMovieToDb("imdbID_O1")).thenReturn(onLineMovieDto);
        when(userFacade.addMovie(null,1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(null)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/addonline")
                .param("imdbID","imdbID_O1"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("userWishes", movieWishDto))
                .andExpect(view().name("movieUserWishes"));
        //then
        verify(moviesFacade,times(1)).addOnLineMovieToDb("imdbID_O1");
        verify(userFacade, times(1)).addMovie(null, 1L);
        verify(userFacade, times(1)).findUsersWishForGivenUser(null);
        verifyNoMoreInteractions(moviesFacade);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testShowWishes() throws Exception {
        //given
        when(userFacade.findAllWishes()).thenReturn(movieWishDtos);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/wishlistadmin"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("wishes", movieWishDtos))
                .andExpect(view().name("movieWishListAdmin"));
        //then
        verify(userFacade, times(1)).findAllWishes();
        verifyNoMoreInteractions(userFacade);
    }
}
