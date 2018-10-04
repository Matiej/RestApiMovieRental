package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

import java.util.ArrayList;
import java.util.List;

public class MockBlueRayMovieDetails {

    public List<BlueRayMovieDetails> blueRayMovieDetails() {

        BlueRayMovieDetails blueRayMovieDetails1 = new BlueRayMovieDetails(
                "imdbID_1",
                "TestTitle1",
                "1999",
                "released1",
                "runtime1",
                "genre1",
                "writer1",
                "actor1",
                "plot1",
                "polski",
                "POLSKA",
                "awards1",
                "www.poster11",
                "HBO1"
        );
        blueRayMovieDetails1.setId(1L);

        BlueRayMovieDetails blueRayMovieDetails2 = new BlueRayMovieDetails(
                "imdbID_2",
                "TestTitle2",
                "2018",
                "released2",
                "runtime2",
                "genre2",
                "writer2",
                "actor2",
                "plot2",
                "niemiecki",
                "Turcja",
                "awards2",
                "www.poster12",
                "HBO2"
        );
        blueRayMovieDetails2.setId(2L);

        BlueRayMovieDetails blueRayMovieDetails3 = new BlueRayMovieDetails(
                "imdbID_3",
                "TestTitle3",
                "2008",
                "released3",
                "runtime3",
                "genre3",
                "writer3",
                "actor3",
                "plot3",
                "rosyjski",
                "CCCP",
                "awards3",
                "www.poster13",
                "HBO3"
        );
        blueRayMovieDetails3.setId(3L);

        BlueRayMovieDetails blueRayMovieDetails3EqualsTest = new BlueRayMovieDetails(
                "imdbID_3",
                "TestTitle3",
                "2008",
                "released3",
                "runtime3",
                "genre3",
                "writer3",
                "actor3",
                "plot3",
                "rosyjski",
                "CCCP",
                "awards3",
                "www.poster13",
                "HBO3"
        );
        blueRayMovieDetails3EqualsTest.setId(3L);

        List<BlueRayMovieDetails> blueRayMovieDetailsList = new ArrayList<>();
        blueRayMovieDetailsList.add(blueRayMovieDetails1);
        blueRayMovieDetailsList.add(blueRayMovieDetails2);
        blueRayMovieDetailsList.add(blueRayMovieDetails3);
        blueRayMovieDetailsList.add(blueRayMovieDetails3EqualsTest);
        return blueRayMovieDetailsList;
    }
}
