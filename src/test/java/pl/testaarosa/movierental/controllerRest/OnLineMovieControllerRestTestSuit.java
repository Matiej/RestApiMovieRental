package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class OnLineMovieControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/online/";
    private MockMvc mockMvc;
    private MockOnLineMovieDto mockOnLineMovieDto;
    private List<OnLineMovieDto> onLineMovieDtoList;

    @InjectMocks
    private OnLineMovieControllerRest onLineMovieControllerRest;

    @Mock
    private MoviesFacade moviesFacade;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        mockMvc = standaloneSetup(onLineMovieControllerRest).build();
        mockOnLineMovieDto = new MockOnLineMovieDto();
        onLineMovieDtoList = mockOnLineMovieDto.onLineMovieDtoList();
    }

    @Test
    public void shouldFindOnLineMovies() throws Exception {
        //given
        when(moviesFacade.getOnLineMovies("SOME TITLE")).thenReturn(onLineMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING+"onlinemovielist")
                .param("title", "SOME TITLE"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(onLineMovieDtoList)));
        //then
        verify(moviesFacade, times(1)).getOnLineMovies("SOME TITLE");
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldFindOnLineMovies404() throws Exception {
        //given
        when(moviesFacade.getOnLineMovies("SOME TITLE")).thenReturn(onLineMovieDtoList);
        //when
        mockMvc.perform(get(MAPPING+"onlinemovielistStatus404")
                .param("title", "SOME TITLE"))
                .andExpect(status().is(404));
        //then
        verify(moviesFacade, times(0)).getOnLineMovies("SOME TITLE");
        verifyNoMoreInteractions(moviesFacade);
    }
}

