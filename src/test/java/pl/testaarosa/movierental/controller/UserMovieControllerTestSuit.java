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
import pl.testaarosa.movierental.domain.dto.UserMovieDto;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.repositories.MockUserMovieDto;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
    private MockUserMovieDto mockUserMovie;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userMovieController).build();
        mockUserMovie = new MockUserMovieDto();
    }

    @Test
    public void testShowUserMovies() throws Exception {
        //given
        List<UserMovieDto> userMovie = mockUserMovie.mockUserMovieList();
        when(userFacade.findAllUserMoviesForGivenUser(null)).thenReturn(userMovie);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/usermovie/movieslist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("userMovies",userMovie))
                .andExpect(model().attribute("userMovies", hasSize(2)))
                .andExpect(view().name("userMoviesList"))
                .andExpect(MockMvcResultMatchers.view().name("userMoviesList"));
        //then
        verify(userFacade, times(1)).findAllUserMoviesForGivenUser(null);
        verifyNoMoreInteractions(userFacade);
    }
}
