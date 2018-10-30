package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.repositories.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class MovieWishControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/wish";
    private MockMvc mockMvc;
    private MockMovieWishDto mockMovieWishDto;
    private List<MovieWishDto> movieWishDtoList;
    private MockOnLineMovieDto mockOnLineMovieDto;
    private List<OnLineMovieDto> onLineMovieDtoList;
    private MockHttpServletRequest request;
    private MockMovieDto mockMovieDto;
    private List<MovieDto> movieDtoList;
    private MockBlueRayMovieDto mockBlueRayMovieDto;
    private List<BlueRayMovieDto> blueRayMovieDtoList;
    private MockDvdMovieDto mockDvdMovieDto;
    private List<DvdMovieDto> dvdMovieDtoList;

    @InjectMocks
    private MovieWishControllerRest movieWishControllerRest;

    @Mock
    private MoviesFacade moviesFacade;
    @Mock
    private UserFacade userFacade;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        mockMvc = standaloneSetup(movieWishControllerRest).build();
        mockMovieWishDto = new MockMovieWishDto();
        movieWishDtoList = mockMovieWishDto.mockMovieWishDtos();
        request = new MockHttpServletRequest();
        mockOnLineMovieDto = new MockOnLineMovieDto();
        onLineMovieDtoList = mockOnLineMovieDto.onLineMovieDtoList();
        mockMovieDto = new MockMovieDto();
        movieDtoList = mockMovieDto.movieDtoList();
        mockBlueRayMovieDto = new MockBlueRayMovieDto();
        blueRayMovieDtoList = mockBlueRayMovieDto.blueRayMovieDto();
        mockDvdMovieDto = new MockDvdMovieDto();
        dvdMovieDtoList = mockDvdMovieDto.dvdMovieDtoList();
    }

    @Test
    public void shouldAddMovieToWishList() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser, 1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(post(MAPPING + "/addmovietowish")
                .param("request", remoteUser)
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(movieWishDto)));
        //then
        verify(userFacade, times(1)).addMovie(
                remoteUser, 1L);
        verify(userFacade, times(1)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldAddMovieToWishListStatus400() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser, 1L)).thenThrow(new MovieNotFoundException("ERROR"));
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(post(MAPPING + "/addmovietowish")
                .param("request", remoteUser)
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(400));
        //then
        verify(userFacade, times(1)).addMovie(
                remoteUser, 1L);
        verify(userFacade, times(0)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldAddMovieToWishListStatus401() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser, 1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenThrow(new UsernameNotFoundException("ERROR"));
        //when
        mockMvc.perform(post(MAPPING + "/addmovietowish")
                .param("request", remoteUser)
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(401));
        //then
        verify(userFacade, times(1)).addMovie(
                remoteUser, 1L);
        verify(userFacade, times(1)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldAddMovieToWishListStatus404() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser, 1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(post(MAPPING + "/addmovietowishStatus404")
                .param("request", remoteUser)
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).addMovie(
                remoteUser, 1L);
        verify(userFacade, times(0)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldAddOnlineMovieToWishListTest() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        OnLineMovieDto onLineMovie = onLineMovieDtoList.get(0);
        when(moviesFacade.addOnLineMovieToDb("xxx")).thenReturn(onLineMovie);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser,1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(post(MAPPING+"/addonline")
        .param("imdbID", "xxx"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(movieWishDto)));
        //then
        verify(userFacade, times(1)).addMovie(remoteUser,null);
        verify(userFacade, times(1)).findUsersWishForGivenUser(remoteUser);
        verify(moviesFacade, times(1)).addOnLineMovieToDb("xxx");
        verifyNoMoreInteractions(userFacade);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldAddOnlineMovieToWishListTest400() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        OnLineMovieDto onLineMovie = onLineMovieDtoList.get(0);
        when(moviesFacade.addOnLineMovieToDb("xxx")).thenThrow(new MovieNotFoundException("ERROR"));
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser,1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(post(MAPPING+"/addonline")
                .param("imdbID", "xxx"))
                .andExpect(status().is(400));
        //then
        verify(userFacade, times(0)).addMovie(remoteUser,null);
        verify(userFacade, times(0)).findUsersWishForGivenUser(remoteUser);
        verify(moviesFacade, times(1)).addOnLineMovieToDb("xxx");
        verifyNoMoreInteractions(userFacade);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldAddOnlineMovieToWishListTest404() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        OnLineMovieDto onLineMovie = onLineMovieDtoList.get(0);
        when(moviesFacade.addOnLineMovieToDb("xxx")).thenReturn(onLineMovie);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser,1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(post(MAPPING+"/addonlineStatus404")
                .param("imdbID", "xxx"))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).addMovie(remoteUser,null);
        verify(userFacade, times(0)).findUsersWishForGivenUser(remoteUser);
        verify(moviesFacade, times(0)).addOnLineMovieToDb("xxx");
        verifyNoMoreInteractions(userFacade);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldAddOnlineMovieToWishListTest401() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        OnLineMovieDto onLineMovie = onLineMovieDtoList.get(0);
        when(moviesFacade.addOnLineMovieToDb("xxx")).thenReturn(onLineMovie);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser,1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenThrow(new UsernameNotFoundException("ERROR USER"));
        //when
        mockMvc.perform(post(MAPPING+"/addonline")
                .param("imdbID", "xxx"))
                .andExpect(status().is(401));
        //then
        verify(userFacade, times(1)).addMovie(remoteUser,null);
        verify(userFacade, times(1)).findUsersWishForGivenUser(remoteUser);
        verify(moviesFacade, times(1)).addOnLineMovieToDb("xxx");
        verifyNoMoreInteractions(userFacade);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldShowWishes() throws Exception {
        //given
        when(userFacade.findAllWishes()).thenReturn(movieWishDtoList);
        //when
        mockMvc.perform(get(MAPPING+"/wishlistadmin"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(movieWishDtoList)));
        //then
        verify(userFacade, times(1)).findAllWishes();
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowWishes404() throws Exception {
        //given
        when(userFacade.findAllWishes()).thenReturn(movieWishDtoList);
        //when
        mockMvc.perform(get(MAPPING+"/wishlistadminStatus404"))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).findAllWishes();
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldshowUserWishes() throws Exception {
        //given
        String remoteUser = request.getRemoteUser();
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(get(MAPPING+"/userwishes"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(movieWishDto)));
        //then
        verify(userFacade, times(1)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldshowUserWishes404() throws Exception {
        //given
        String remoteUser = request.getRemoteUser();
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(get(MAPPING+"/userwishesStatus404"))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldshowUserWishes401() throws Exception {
        //given
        String remoteUser = request.getRemoteUser();
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenThrow(new UsernameNotFoundException("USER ERROR"));
        //when
        mockMvc.perform(get(MAPPING+"/userwishes"))
                .andExpect(status().is(401));
        //then
        verify(userFacade, times(1)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testMovieDetails_OnLineMovie() throws Exception {
        //given
        MovieDto movieDto = movieDtoList.get(0);
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(0);
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        DvdMovieDto dvdMovieDto = dvdMovieDtoList.get(0);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        when(moviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDto);
        when(moviesFacade.findOnLineById(1L)).thenReturn(onLineMovieDto);
        when(moviesFacade.findDvdById(1L)).thenReturn(dvdMovieDto);
        //when
        mockMvc.perform(get(MAPPING+"/moviedetails")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(movieDto)));
        //then
        verify(moviesFacade, times(1)).findMovieById(1l);
        verify(moviesFacade, times(0)).findBlueRaById(1l);
        verify(moviesFacade, times(1)).findOnLineById(1l);
        verify(moviesFacade, times(0)).findDvdById(1l);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void testMovieDetails_OnLineMovie400() throws Exception {
        //given
        MovieDto movieDto = movieDtoList.get(0);
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(0);
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        DvdMovieDto dvdMovieDto = dvdMovieDtoList.get(0);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        when(moviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDto);
        when(moviesFacade.findOnLineById(1L)).thenThrow(new MovieNotFoundException("ONLINEMOVIE ERROR"));
        when(moviesFacade.findDvdById(1L)).thenReturn(dvdMovieDto);
        //when
        mockMvc.perform(get(MAPPING+"/moviedetails")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(400));
        //then
        verify(moviesFacade, times(1)).findMovieById(1l);
        verify(moviesFacade, times(0)).findBlueRaById(1l);
        verify(moviesFacade, times(1)).findOnLineById(1l);
        verify(moviesFacade, times(0)).findDvdById(1l);
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void testMovieDetails_OnLineMovie404() throws Exception {
        //given
        MovieDto movieDto = movieDtoList.get(0);
        BlueRayMovieDto blueRayMovieDto = blueRayMovieDtoList.get(0);
        OnLineMovieDto onLineMovieDto = onLineMovieDtoList.get(0);
        DvdMovieDto dvdMovieDto = dvdMovieDtoList.get(0);
        when(moviesFacade.findMovieById(1L)).thenReturn(movieDto);
        when(moviesFacade.findBlueRaById(1L)).thenReturn(blueRayMovieDto);
        when(moviesFacade.findOnLineById(1L)).thenReturn(onLineMovieDto);
        when(moviesFacade.findDvdById(1L)).thenReturn(dvdMovieDto);
        //when
        mockMvc.perform(get(MAPPING+"/moviedetailsStatus404")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(404));
        //then
        verify(moviesFacade, times(0)).findMovieById(1l);
        verify(moviesFacade, times(0)).findBlueRaById(1l);
        verify(moviesFacade, times(0)).findOnLineById(1l);
        verify(moviesFacade, times(0)).findDvdById(1l);
        verifyNoMoreInteractions(moviesFacade);
    }

}
