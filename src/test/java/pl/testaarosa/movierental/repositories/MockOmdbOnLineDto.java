package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OmdbOnLineDto;

import java.util.ArrayList;
import java.util.List;

public class MockOmdbOnLineDto {

    public List<OmdbOnLineDto> omdbOnLineDtoList() {

        OmdbOnLineDto omdbOnLineDto1 = new OmdbOnLineDto(
                "Online TestTitle1",
                "1988",
                "imdbID_O1",
                "horror",
                "www.Online-poster11");

        OmdbOnLineDto omdbOnLineDto2 = new OmdbOnLineDto(
                "Online TestTitle2",
                "2010",
                "imdbID_O2",
                "horror",
                "www.Online-poster12");

        OmdbOnLineDto omdbOnLineDto2EwualsTest = new OmdbOnLineDto(
                "Online TestTitle2",
                "2010",
                "imdbID_O2",
                "horror",
                "www.Online-poster12");

        List<OmdbOnLineDto> omdbOnLineDtoList = new ArrayList<>();
        omdbOnLineDtoList.add(omdbOnLineDto1);
        omdbOnLineDtoList.add(omdbOnLineDto2);
        omdbOnLineDtoList.add(omdbOnLineDto2EwualsTest);
        return omdbOnLineDtoList;
    }
}
