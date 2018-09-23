package pl.testaarosa.movierental.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserMovieFormDto;
import pl.testaarosa.movierental.repositories.MockUserMovie;
import pl.testaarosa.movierental.repositories.MockUserMovieDto;
import pl.testaarosa.movierental.repositories.MockUserMovieFormDto;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(UserMovieController.class)
@WebAppConfiguration
public class UserMovieControllerTestSuit {

    @InjectMocks
    private UserMovieController userMovieController;

    @Mock
    private UserFacade userFacade;

    private MockMvc mockMvc;
    private MockUserMovieDto mockUserMovieDto = new MockUserMovieDto();
    private List<UserMovieDto> userMovieDtoList;
    private MockUserMovieFormDto mockUserMovieForm = new MockUserMovieFormDto();
    private List<UserMovieFormDto> mockMovieFormList;
    private MockUserMovie mockUserMovie = new MockUserMovie();
    private List<UserMovie> userMovieList;
    private MockHttpServletRequest request = new MockHttpServletRequest();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userMovieController).build();
        userMovieDtoList = mockUserMovieDto.mockUserMovieList();
        userMovieList = mockUserMovie.userMovieList();
        mockMovieFormList = mockUserMovieForm.userMovieFormList();
    }

    @Test
    public void testShowUserMovies() throws Exception {
        //given
        when(userFacade.findAllUserMoviesForGivenUser(null)).thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/usermovie/movieslist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("userMovies", userMovieDtoList))
                .andExpect(model().attribute("userMovies", hasSize(2)))
                .andExpect(MockMvcResultMatchers.view().name("userMoviesList"));
        //then
        verify(userFacade, times(1)).findAllUserMoviesForGivenUser(null);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testShowSearchTitleResult() throws Exception {
        //given
        when(userFacade.findAllUserMoviesByTitleContaining(null, "My Nice Movie1"))
                .thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/usermovie/movieslistsearch")
                .param("title", "My Nice Movie1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("searchresult", userMovieDtoList))
                .andExpect(model().attribute("searchresult", hasSize(2)))
                .andExpect(MockMvcResultMatchers.view().name("userMoviesSearchResult"));
        //then
        verify(userFacade, times(1)).findAllUserMoviesByTitleContaining(null,
                "My Nice Movie1");
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testAddNewMovie() throws Exception {
        //given
        UserMovieFormDto userMovieForm = mockMovieFormList.get(1);
        UserMovie expect = userMovieList.get(0);
        when(userFacade.addUserMovie("znikenson@gmail.com", userMovieForm)).thenReturn(expect);
        when(userFacade.findAllUserMoviesForGivenUser(request.getRemoteUser())).thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/usermovie/addnewmovie")
                .param("imdbID","xxx1")
                .param("title","My Nice Movie1")
                .param("year","1999")
                .accept(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(model().attribute("userMovies", userMovieDtoList))
                .andExpect(model().attribute("userMovies", hasSize(2)))
                .andExpect((view().name("userMoviesList")));
        UserMovie result = userFacade.addUserMovie("znikenson@gmail.com", userMovieForm);
        //then
        assertEquals(expect, result);
    }

    @Test
    public void testShowForm() throws Exception {
        //given
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/usermovie/addnewmovie"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("userMoviesForm"))
                .andExpect(model().attribute("userMovie", new UserMovieFormDto()));
    }

    @Test
    public void testMovieDetail() throws Exception {
        //given
        UserMovieDto userMovieDto = mockUserMovieDto.mockUserMovieList().get(0);
        when(userFacade.findOneUserMovie(1L)).thenReturn(userMovieDto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/usermovie/showmovie")
                .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("userMovieDetails"))
                .andExpect(model().attribute("userMovieDetail", userMovieDto));
        //then
        verify(userFacade, times(1)).findOneUserMovie(1L);
        verifyNoMoreInteractions(userFacade);
    }

    @Test
    public void testDelUserMovie() throws Exception {
        //when
        when(userFacade.findAllUserMoviesForGivenUser(null)).thenReturn(userMovieDtoList);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/usermovie/delusermovie")
                .param("id", String.valueOf(1L)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("userMoviesList"))
                .andExpect(model().attribute("userMovies", userMovieDtoList));
        List<UserMovieDto> result = userFacade.findAllUserMoviesForGivenUser(null);
        //then
        assertEquals(userMovieDtoList,result);
        verify(userFacade,times(1)).deleteUserMovie(1L);
    }
}
