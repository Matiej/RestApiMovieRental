package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.BlueRayMovie;

import java.util.ArrayList;
import java.util.List;

public class MockBlueRayMovie {

    private MockBlueRayMovieDetails mockBlueRayMovieDetails = new MockBlueRayMovieDetails();
    private MockMovieWish mockMovieWish = new MockMovieWish();

    public List<BlueRayMovie> blueRayMovieList() {

        BlueRayMovie blueRayMovie1 = new BlueRayMovie();
        blueRayMovie1.setId(1L);
        blueRayMovie1.setTitle("TestTitle1");
        blueRayMovie1.setImdbID("imdbID_1");
        blueRayMovie1.setPoster("www.poster11");
        blueRayMovie1.setSupplier("BlueRayMovie");
        blueRayMovie1.setMovieWishList(mockMovieWish.mockMovieWish());
        blueRayMovie1.setBlueRayMovieDetails(mockBlueRayMovieDetails.blueRayMovieDetails().get(0));

        BlueRayMovie blueRayMovie2 = new BlueRayMovie();
        blueRayMovie2.setId(2L);
        blueRayMovie2.setTitle("TestTitle2");
        blueRayMovie2.setImdbID("imdbID_2");
        blueRayMovie2.setPoster("www.poster12");
        blueRayMovie2.setSupplier("BlueRayMovie");
        blueRayMovie2.setMovieWishList(mockMovieWish.mockMovieWish());
        blueRayMovie2.setBlueRayMovieDetails(mockBlueRayMovieDetails.blueRayMovieDetails().get(1));

        BlueRayMovie blueRayMovie3 = new BlueRayMovie();
        blueRayMovie3.setId(3L);
        blueRayMovie3.setTitle("TestTitle3");
        blueRayMovie3.setImdbID("imdbID_3");
        blueRayMovie3.setPoster("www.poster13");
        blueRayMovie3.setSupplier("BlueRayMovie");
        blueRayMovie3.setMovieWishList(mockMovieWish.mockMovieWish());
        blueRayMovie3.setBlueRayMovieDetails(mockBlueRayMovieDetails.blueRayMovieDetails().get(2));

        BlueRayMovie blueRayMovie4Equals = new BlueRayMovie();
        blueRayMovie4Equals.setId(3L);
        blueRayMovie4Equals.setTitle("TestTitle3");
        blueRayMovie4Equals.setImdbID("imdbID_3");
        blueRayMovie4Equals.setPoster("www.poster13");
        blueRayMovie4Equals.setSupplier("BlueRayMovie");
        blueRayMovie4Equals.setMovieWishList(mockMovieWish.mockMovieWish());
        blueRayMovie4Equals.setBlueRayMovieDetails(mockBlueRayMovieDetails.blueRayMovieDetails().get(2));

        List<BlueRayMovie> blueRayMovielist = new ArrayList<>();
        blueRayMovielist.add(blueRayMovie1);
        blueRayMovielist.add(blueRayMovie2);
        blueRayMovielist.add(blueRayMovie3);
        blueRayMovielist.add(blueRayMovie4Equals);

        return blueRayMovielist;
    }
}
