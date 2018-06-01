package pl.testaarosa.movierental.supplier;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.cfg.OmbdapiConfig;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OmbdMovieSupplierTest {

    @InjectMocks
    private OmbdMovieSupplier ombdMovieSupplier;

    @Mock
    private OmbdapiConfig ombdapiConfig;

    @Before
    public void init() {
        when(ombdapiConfig.getOmbdEndPoint()).thenReturn("http://test.com/");
        when(ombdapiConfig.getOmbdKey()).thenReturn("test_apikey");
    }

    @Test
    public void shouldFetchOmbdMovies() throws URISyntaxException {
        // given
        String title = "iron";
        int page = 1;
        URI uri = new URI("http://test.com/?s=iron&type=movie&page=1&apikey=test_apikey");
        //when
        URI result = ombdMovieSupplier.OmbdSupplierSource(1, title);
        //then
        assertEquals(uri, result);
    }

    @Test
    public void shouldFetchOmbdMoviesDetails() throws URISyntaxException {
        // given
        String modieId = "1xxx1";
        URI uri = new URI("http://test.com/?i=1xxx1&plot=full&apikey=test_apikey");
        //when
        URI result = ombdMovieSupplier.OmbdSupplierDetails(modieId);
        //then
        assertEquals(uri,result);
    }
}