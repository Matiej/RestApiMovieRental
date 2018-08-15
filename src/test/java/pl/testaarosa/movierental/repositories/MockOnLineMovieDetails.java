package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.OnLineMovieDetails;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Optional.ofNullable;

public class MockOnLineMovieDetails {

    public CompletableFuture<List<OnLineMovieDetails>> onLineMovieDetails() {

        OnLineMovieDetails onLineMovieDetails1 = new OnLineMovieDetails(
                "imdbID_O1",
                "Online TestTitle1",
                "1988",
                "released1",
                "runtime1",
                "genre1",
                "writer1",
                "actor1",
                "plot1",
                "polski",
                "POLSKA",
                "awards1",
                "www.Online-poster11",
                "AXN"
        );
        onLineMovieDetails1.setId(1L);

        OnLineMovieDetails onLineMovieDetails2 = new OnLineMovieDetails(
                "imdbID_O2",
                "Online TestTitle2",
                "2010",
                "released2",
                "runtime2",
                "genre2",
                "writer2",
                "actor2",
                "plot2",
                "syjonski",
                "SanEskobar",
                "awards212",
                "www.Online-poster12",
                "AXN"
        );
        onLineMovieDetails2.setId(2L);

        List<OnLineMovieDetails> onLineMovieDetailsList = new ArrayList<>();
        onLineMovieDetailsList.add(onLineMovieDetails1);
        onLineMovieDetailsList.add(onLineMovieDetails2);

        return CompletableFuture.completedFuture(ofNullable(onLineMovieDetailsList).orElse(new LinkedList<>()));
    }
}
