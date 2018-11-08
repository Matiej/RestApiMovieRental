package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockUserMovieDto;
import pl.testaarosa.movierental.repositories.MockUserMovieFormDto;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class UserMovieControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/usermovie/";
    private MockMvc mockMvc;
    private MockUserMovieDto mockUserMovieDto;
    private List<UserMovieDto> userMovieDtoList;
    private MockUserMovieFormDto mockUsermovieFormDto;
    private List<UserMovieFormDto> userMovieFormDtoList;

    @InjectMocks
    private UserMovieControllerRest userMovieControllerRest;

    @Mock
    private UserFacade userFacade;

    @Before
    public void init() {
        mockMvc = standaloneSetup(userMovieControllerRest).build();
        mockUserMovieDto = new MockUserMovieDto();
        userMovieDtoList = mockUserMovieDto.mockUserMovieList();
        mockUsermovieFormDto = new MockUserMovieFormDto();
        userMovieFormDtoList = mockUsermovieFormDto.userMovieFormList();
    }

    @Test
    public void shouldShowUserMovies() throws Exception {
        //given
        when(userFacade.findAllUserMoviesForGivenUser(null)).thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING + "movieslist"))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(userMovieDtoList)));
        //then
        verify(userFacade, times(1)).findAllUserMoviesForGivenUser(null);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowUserMovies404() throws Exception {
        //given
        when(userFacade.findAllUserMoviesForGivenUser(null)).thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING + "movieslistStatus404"))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).findAllUserMoviesForGivenUser(null);
        verifyNoMoreInteractions(userFacade);
    }


    @Test
    public void shouldShowUserMovies401() throws Exception {
        //given
        when(userFacade.findAllUserMoviesForGivenUser(null)).thenThrow(new UsernameNotFoundException("NO REMOTE USER"));
        //when
        mockMvc.perform(get(MAPPING + "movieslist"))
                .andExpect(status().is(401));
        //then
        verify(userFacade, times(1)).findAllUserMoviesForGivenUser(null);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowUserMovies400() throws Exception {
        //given
        when(userFacade.findAllUserMoviesForGivenUser(null)).thenThrow(new MovieNotFoundException("NO MOVIE FOUND"));
        //when
        mockMvc.perform(get(MAPPING + "movieslist"))
                .andExpect(status().is(400));
        //then
        verify(userFacade, times(1)).findAllUserMoviesForGivenUser(null);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowSearchTitleResult() throws Exception {
        //given
        when(userFacade.findAllUserMoviesByTitleContaining(null, "my title")).thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING + "movieslistsearch")
                .param("title", "my title"))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(userMovieDtoList)));
        //then
        verify(userFacade, times(1)).findAllUserMoviesByTitleContaining(null, "my title");
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowSearchTitleResult404() throws Exception {
        //given
        when(userFacade.findAllUserMoviesByTitleContaining(null, "my title")).thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING + "movieslistsearchStatus404")
                .param("title", "my title"))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).findAllUserMoviesByTitleContaining(null, "my title");
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowSearchTitle401() throws Exception {
        //given
        when(userFacade.findAllUserMoviesByTitleContaining(null, "my title")).thenThrow(new UsernameNotFoundException("NO USER"));
        //when
        mockMvc.perform(get(MAPPING + "movieslistsearch")
                .param("title", "my title"))
                .andExpect(status().is(401));
        //then
        verify(userFacade, times(1)).findAllUserMoviesByTitleContaining(null, "my title");
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldAddNewMovie() throws Exception {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        UserMovieFormDto userMovieFormDto = userMovieFormDtoList.get(0);
        when(userFacade.addUserMovieRest(null, userMovieFormDto)).thenReturn(userMovieDto);
        //when
        mockMvc.perform(post(MAPPING + "addnewmovie")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(converter.jsonInString(userMovieFormDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(userMovieDto)));
        //then
        verify(userFacade, times(1)).addUserMovieRest(null, userMovieFormDto);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldAddNewMovie404() throws Exception {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        UserMovieFormDto userMovieFormDto = userMovieFormDtoList.get(0);
        when(userFacade.addUserMovieRest(null, userMovieFormDto)).thenReturn(userMovieDto);
        //when
        mockMvc.perform(post(MAPPING + "addnewmovieStatus404")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(converter.jsonInString(userMovieFormDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).addUserMovieRest(null, userMovieFormDto);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowMovie() throws Exception {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        when(userFacade.findOneUserMovie(1L)).thenReturn(userMovieDto);
        //when
        mockMvc.perform(get(MAPPING + "userMovie")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.jsonInString(userMovieDto)));
        //then
        verify(userFacade, times(1)).findOneUserMovie(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowMovie400() throws Exception {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        when(userFacade.findOneUserMovie(1L)).thenThrow(new MovieNotFoundException("NO mOVIE FOUND"));
        //when
        mockMvc.perform(get(MAPPING + "userMovie")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(400));
        //then
        verify(userFacade, times(1)).findOneUserMovie(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shouldShowMovie404() throws Exception {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        when(userFacade.findOneUserMovie(1L)).thenReturn(userMovieDto);
        //when
        mockMvc.perform(get(MAPPING + "userMovieStatus404")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).findOneUserMovie(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shoulddeleteUserMovie() throws Exception {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        when(userFacade.findOneUserMovie(1L)).thenReturn(userMovieDto);
        //when
        mockMvc.perform(delete(MAPPING + "delusermovie")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(userMovieDto)));
        //then
        verify(userFacade, times(1)).findOneUserMovie(1l);
        verify(userFacade, times(1)).deleteUserMovie(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shoulddeleteUserMovie400() throws Exception {
        //given
        when(userFacade.findOneUserMovie(1L)).thenThrow(new MovieNotFoundException("NO MOVIE"));
        //when
        mockMvc.perform(delete(MAPPING + "delusermovie")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(400));
        //then
        verify(userFacade, times(1)).findOneUserMovie(1l);
        verify(userFacade, times(0)).deleteUserMovie(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void shoulddeleteUserMovie404() throws Exception {
        //given
        UserMovieDto userMovieDto = userMovieDtoList.get(0);
        when(userFacade.findOneUserMovie(1L)).thenReturn(userMovieDto);
        //when
        mockMvc.perform(delete(MAPPING + "delusermovieStatus404")
                .param("movieId", String.valueOf(1L)))
                .andExpect(status().is(404));
        //then
        verify(userFacade, times(0)).findOneUserMovie(1l);
        verify(userFacade, times(0)).deleteUserMovie(1L);
        verifyNoMoreInteractions(userFacade);
    }
}
