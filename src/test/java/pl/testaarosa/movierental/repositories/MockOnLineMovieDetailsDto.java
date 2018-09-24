package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;

import java.util.ArrayList;
import java.util.List;

public class MockOnLineMovieDetailsDto {

    public List<OnLineMovieDetailsDto> onLineMovieDetailsDtos() {

        OnLineMovieDetailsDto onLineMovieDetails1 = new OnLineMovieDetailsDto(
                null,
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

        OnLineMovieDetailsDto onLineMovieDetails2 = new OnLineMovieDetailsDto(
                null,
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

        List<OnLineMovieDetailsDto> onLineMovieDetailsList = new ArrayList<>();
        onLineMovieDetailsList.add(onLineMovieDetails1);
        onLineMovieDetailsList.add(onLineMovieDetails2);
        return onLineMovieDetailsList;
    }
}
