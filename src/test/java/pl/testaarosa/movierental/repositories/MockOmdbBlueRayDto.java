package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OmdbBlueRayDto;

import java.util.ArrayList;
import java.util.List;

public class MockOmdbBlueRayDto {

    public List<OmdbBlueRayDto> omdbBlueRayDto() {
        List<OmdbBlueRayDto> omdbBlueRayDtoList = new ArrayList<>();
        OmdbBlueRayDto omdbBlueRayDto1 = new OmdbBlueRayDto(
                "TestTitle1",
                "1999",
                "imdbID_1",
                "horror",
                "www.poster11");

        OmdbBlueRayDto omdbBlueRayDto2 = new OmdbBlueRayDto(
                "TestTitle2",
                "1999",
                "imdbID_2",
                "horror",
                "www.poster12");

        OmdbBlueRayDto omdbBlueRayDto3 = new OmdbBlueRayDto(
                "TestTitle3",
                "1999",
                "imdbID_3",
                "horror",
                "www.poster13");

        OmdbBlueRayDto omdbBlueRayDto3EqualsTest = new OmdbBlueRayDto(
                "TestTitle3",
                "1999",
                "imdbID_3",
                "horror",
                "www.poster13");

        omdbBlueRayDtoList.add(omdbBlueRayDto1);
        omdbBlueRayDtoList.add(omdbBlueRayDto2);
        omdbBlueRayDtoList.add(omdbBlueRayDto3);
        omdbBlueRayDtoList.add(omdbBlueRayDto3EqualsTest);
        return omdbBlueRayDtoList;
    }
}
