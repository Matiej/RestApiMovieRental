package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;

import java.util.ArrayList;
import java.util.List;

public class MockBlueRayMovieDto {

    private MockBlueRayMovieDetails mockBlueRayMovieDetails = new MockBlueRayMovieDetails();

    public List<BlueRayMovieDto> blueRayMovieDto() {
        BlueRayMovieDto blueRayMovie1 = new BlueRayMovieDto();
        blueRayMovie1.setId(1L);
        blueRayMovie1.setTitle("TestTitle1");
        blueRayMovie1.setImdbID("imdbID_1");
        blueRayMovie1.setPoster("www.poster11");
        blueRayMovie1.setSupplier("BlueRayMovie");
        blueRayMovie1.setBlueRayMovieDetails(mockBlueRayMovieDetails.blueRayMovieDetails().get(0));

        BlueRayMovieDto blueRayMovie2 = new BlueRayMovieDto();
        blueRayMovie2.setId(2L);
        blueRayMovie2.setTitle("TestTitle2");
        blueRayMovie2.setImdbID("imdbID_2");
        blueRayMovie2.setPoster("www.poster12");
        blueRayMovie2.setSupplier("BlueRayMovie");
        blueRayMovie2.setBlueRayMovieDetails(mockBlueRayMovieDetails.blueRayMovieDetails().get(1));

        BlueRayMovieDto blueRayMovie3 = new BlueRayMovieDto();
        blueRayMovie3.setId(3L);
        blueRayMovie3.setTitle("TestTitle3");
        blueRayMovie3.setImdbID("imdbID_3");
        blueRayMovie3.setPoster("www.poster13");
        blueRayMovie3.setSupplier("BlueRayMovie");
        blueRayMovie3.setBlueRayMovieDetails(mockBlueRayMovieDetails.blueRayMovieDetails().get(2));

        List<BlueRayMovieDto> blueRayMovielist = new ArrayList<>();
        blueRayMovielist.add(blueRayMovie1);
        blueRayMovielist.add(blueRayMovie2);
        blueRayMovielist.add(blueRayMovie3);

        return blueRayMovielist;
    }
}
