package pl.testaarosa.movierental.controllerRest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.facade.MoviesFacade;
import pl.testaarosa.movierental.repositories.Converter;
import pl.testaarosa.movierental.repositories.MockOnLineMovieDetailsDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class OnLineMovieDetailsControllerRestTestSuit {

    private final Converter converter = new Converter();
    private final static String MAPPING = "/mrapi/online/";
    private MockMvc mockMvc;
    private MockOnLineMovieDetailsDto mockOnLineMovieDetailsDto;
    private List<OnLineMovieDetailsDto> onLineMovieDetailsDtoList;
    @InjectMocks
    private OnLineMovieDetailsControllerRest onLineMovieDetailsControllerRest;

    @Mock
    private MoviesFacade moviesFacade;

    @Before
    public void init() throws ExecutionException, InterruptedException {
        mockMvc = standaloneSetup(onLineMovieDetailsControllerRest).build();
        mockOnLineMovieDetailsDto = new MockOnLineMovieDetailsDto();
        onLineMovieDetailsDtoList = mockOnLineMovieDetailsDto.onLineMovieDetailsDtos();
    }

    @Test
    public void shouldFindOnLineMovieDetail() throws Exception {
        //given
        OnLineMovieDetailsDto expect = onLineMovieDetailsDtoList.get(0);
        when(moviesFacade.getOnLineMovieDetails("xxx1")).thenReturn(expect);
        //when
        mockMvc.perform(get(MAPPING+"/onlinedetail")
        .param("imdbId", "xxx1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(converter.jsonInString(expect)));
        //then
        verify(moviesFacade, times(1)).getOnLineMovieDetails("xxx1");
        verifyNoMoreInteractions(moviesFacade);
    }

    @Test
    public void shouldFindOnLineMovieDetail404() throws Exception {
        //given
        OnLineMovieDetailsDto expect = onLineMovieDetailsDtoList.get(0);
        when(moviesFacade.getOnLineMovieDetails("xxx1")).thenReturn(expect);
        //when
        mockMvc.perform(get(MAPPING+"/onlinedetailStatus404")
                .param("imdbId", "xxx1"))
                .andExpect(status().is(404));
        //then
        verify(moviesFacade, times(0)).getOnLineMovieDetails("xxx1");
        verifyNoMoreInteractions(moviesFacade);
    }
}
