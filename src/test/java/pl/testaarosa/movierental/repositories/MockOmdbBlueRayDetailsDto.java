package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OmdbBlueRayDetailsDto;

public class MockOmdbBlueRayDetailsDto {

    public OmdbBlueRayDetailsDto omdbBlueRayDetailsDto() {

        return new OmdbBlueRayDetailsDto(
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
                "HBO1");
    }
}
