package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OmdbOnLineDetailsDto;

import java.util.ArrayList;
import java.util.List;

public class MockOmdbOnLineDetailsDto {

    public List<OmdbOnLineDetailsDto> omdbOnLineDetailsDtoList() {
        OmdbOnLineDetailsDto omdbOnLineDetailsDto1 = new OmdbOnLineDetailsDto(
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
                "AXN");

        OmdbOnLineDetailsDto omdbOnLineDetailsDto2 = new OmdbOnLineDetailsDto(
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

        OmdbOnLineDetailsDto omdbOnLineDetailsDto2EqualsTest = new OmdbOnLineDetailsDto(
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
                "AXN");

        List<OmdbOnLineDetailsDto> omdbOnLineDetailsDto1List = new ArrayList<>();
        omdbOnLineDetailsDto1List.add(omdbOnLineDetailsDto1);
        omdbOnLineDetailsDto1List.add(omdbOnLineDetailsDto2);
        omdbOnLineDetailsDto1List.add(omdbOnLineDetailsDto2EqualsTest);
        return omdbOnLineDetailsDto1List;
    }
}
