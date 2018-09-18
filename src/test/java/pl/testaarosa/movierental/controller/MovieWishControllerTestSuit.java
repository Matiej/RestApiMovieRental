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
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.repositories.*;

import java.util.ArrayList;
import java.util.LinkedList;
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
    private MockMovieDto mockMovieDto = new MockMovieDto();
    private MockBlueRayMovieDto blueRayMovieDto = new MockBlueRayMovieDto();
    private List<BlueRayMovieDto> blueRayMovieDtos = new ArrayList<>();
    private MockDvdMovieDto mockDvdMovieDto = new MockDvdMovieDto();
    private List<DvdMovieDto> dvdMovieDtoList = new LinkedList<>();

    @Before
    public void init() throws ExecutionException, InterruptedException {
        mockMvc = MockMvcBuilders.standaloneSetup(movieWishController).build();
        movieWishDtos = mockMovieWishDto.mockMovieWishDtos();
        onLineMovieDtoList = mockOnLineMovieDto.onLineMovieDtoList();
        blueRayMovieDtos = blueRayMovieDto.blueRayMovieDto();
        dvdMovieDtoList = mockDvdMovieDto.dvdMovieDtoList();
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
        verify(userFacade, times(1)).findUsersWishForGivenUser(null);
        verify(userFacade, times(1)).addMovie(null, 1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testAddOnlineMovieToWishList() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtos.get(0);
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        when(moviesFacade.addOnLineMovieToDb("imdbID_O1")).thenReturn(onLineMovieDto);
        when(userFacade.addMovie(null, 1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(null)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/addonline")
                .param("imdbID", "imdbID_O1"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("userWishes", movieWishDto))
                .andExpect(view().name("movieUserWishes"));
        //then
        verify(moviesFacade, times(1)).addOnLineMovieToDb("imdbID_O1");
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

    @Test
    public void testShowUserWishes() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtos.get(0);
        when(userFacade.findUsersWishForGivenUser(null)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/userwishes"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("userWishes", movieWishDto))
                .andExpect(view().name("movieUserWishes"));
        //then
        verify(userFacade, times(1)).findUsersWishForGivenUser(null);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testWishDetail() throws Exception {
        //given
        MovieWishDto movieWishDto = mockMovieWishDto.mockMovieWishDtos().get(0);
        List<MovieDto> movieDtoList = mockMovieDto.movieDtoList();
        when(userFacade.findById(1L)).thenReturn(movieWishDto);
        when(userFacade.findMoviesForWishByWishId(1L)).thenReturn(movieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/wishdetails")
        .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("wishDetailsMovies", movieDtoList))
                .andExpect(view().name("movieWishDetailsAdmin"));
        //then
        verify(userFacade, times(1)).findById(1L);
        verify(userFacade, times(1)).findMoviesForWishByWishId(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldMovieDetailsForBlueRayMovie() throws Exception {
        //given
        MovieDto movieDto = mockMovieDto.movieDtoBlueRay();
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtos.get(0);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        when(moviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/moviedetails")
                .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("movieDetail", blueRayMovieDto))
                .andExpect(view().name("blueRayMoviesDetails"));
        //then
        verify(moviesFacade, times(1)).findMovieById(1L);
        verify(moviesFacade, times(1)).findBlueRaById(1L);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldMovieDetailsForOnLineMovie() throws Exception {
        //given
        MovieDto movieDto = mockMovieDto.movieDtoOnLine();
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        when(moviesFacade.findOnLineById(1L)).thenReturn(onLineMovieDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/moviedetails")
                .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("onLineMovieDetailsDb", onLineMovieDto))
                .andExpect(view().name("onLineMovieDetailsDb"));
        //then
        verify(moviesFacade, times(1)).findMovieById(1L);
        verify(moviesFacade, times(1)).findOnLineById(1L);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldMovieDetailsForDvdMovie() throws Exception {
        MovieDto movieDto = mockMovieDto.movieDtoDvd();
        DvdMovieDto dvdMovieDto = dvdMovieDtoList.get(0);
        when(moviesFacade.findDvdById(1L)).thenReturn(dvdMovieDto);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/watchwish/moviedetails")
                .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("dvdMovieDetail", dvdMovieDto))
                .andExpect(view().name("dvdMovieDetails"));
        //then
        verify(moviesFacade, times(1)).findMovieById(1L);
        verify(moviesFacade, times(1)).findDvdById(1L);
        verifyNoMoreInteractions(moviesFacade);
    }
}
