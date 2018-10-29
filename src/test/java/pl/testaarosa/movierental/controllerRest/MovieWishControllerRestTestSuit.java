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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.MovieWishDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockMovieWishDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class MovieWishControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/wish";
    private MockMvc mockMvc;
    private MockMovieWishDto mockMovieWishDto;
    private List<MovieWishDto> movieWishDtoList;
    private MockHttpServletRequest request;

    @InjectMocks
    private MovieWishControllerRest movieWishControllerRest;

    @Mock
    private MoviesFacade moviesFacade;
    @Mock
    private UserFacade userFacade;

    @Before
    public void init() {
        mockMvc = standaloneSetup(movieWishControllerRest).build();
        mockMovieWishDto = new MockMovieWishDto();
        movieWishDtoList = mockMovieWishDto.mockMovieWishDtos();
        request = new MockHttpServletRequest();
    }

    @Test
    public void shouldAddMovieToWishList() throws Exception {
        //given
        MovieWishDto movieWishDto = movieWishDtoList.get(0);
        String remoteUser = request.getRemoteUser();
        when(userFacade.addMovie(remoteUser, 1L)).thenReturn(movieWishDto);
        when(userFacade.findUsersWishForGivenUser(remoteUser)).thenReturn(movieWishDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.post(MAPPING + "/addmovietowish")
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
        mockMvc.perform(MockMvcRequestBuilders.post(MAPPING + "/addmovietowish")
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
        mockMvc.perform(MockMvcRequestBuilders.post(MAPPING + "/addmovietowish")
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
        mockMvc.perform(MockMvcRequestBuilders.post(MAPPING + "/addmovietowishStatus404")
                .param("request", remoteUser)
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).addMovie(
                remoteUser, 1L);
        verify(userFacade, times(0)).findUsersWishForGivenUser(remoteUser);
        verifyNoMoreInteractions(userFacade);
    }
}
