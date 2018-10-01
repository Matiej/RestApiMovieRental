package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OmdbBlueRayPaginationDto;

import java.util.ArrayList;
import java.util.List;

public class MockOmdbBlueRayPaginationDto {

    private MockOmdbBlueRayDto mockOmdbBlueRayDto = new MockOmdbBlueRayDto();

    public List<OmdbBlueRayPaginationDto> omdbBlueRayPaginationDtos() {
        OmdbBlueRayPaginationDto omdbBlueRayPaginationDto1 = new OmdbBlueRayPaginationDto();
        omdbBlueRayPaginationDto1.setOmdbBlueRayDtos(mockOmdbBlueRayDto.omdbBlueRayDto());
        omdbBlueRayPaginationDto1.setTotalResults("111");

        OmdbBlueRayPaginationDto omdbBlueRayPaginationDto2 = new OmdbBlueRayPaginationDto();
        omdbBlueRayPaginationDto2.setOmdbBlueRayDtos(mockOmdbBlueRayDto.omdbBlueRayDto());
        omdbBlueRayPaginationDto2.setTotalResults("111");

        List<OmdbBlueRayPaginationDto> omdbBlueRayPaginationDtoList = new ArrayList<>();
        omdbBlueRayPaginationDtoList.add(omdbBlueRayPaginationDto1);
        omdbBlueRayPaginationDtoList.add(omdbBlueRayPaginationDto2);
        return omdbBlueRayPaginationDtoList;

    }
}
