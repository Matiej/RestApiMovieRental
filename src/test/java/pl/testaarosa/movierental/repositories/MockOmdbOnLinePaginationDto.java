package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OmdbOnLinePaginationDto;

import java.util.ArrayList;
import java.util.List;

public class MockOmdbOnLinePaginationDto {

    private MockOmdbOnLineDto mockOmdbOnLineDto = new MockOmdbOnLineDto();

    public List<OmdbOnLinePaginationDto> omdbOnLinePaginationDto() {
        OmdbOnLinePaginationDto omdbOnLinePaginationDto1 = new OmdbOnLinePaginationDto();
        omdbOnLinePaginationDto1.setOmdbOnLineDtos(mockOmdbOnLineDto.omdbOnLineDtoList());
        omdbOnLinePaginationDto1.setTotalResults("111");

        OmdbOnLinePaginationDto omdbOnLinePaginationDto2 = new OmdbOnLinePaginationDto();
        omdbOnLinePaginationDto2.setOmdbOnLineDtos(mockOmdbOnLineDto.omdbOnLineDtoList());
        omdbOnLinePaginationDto2.setTotalResults("111");
        List<OmdbOnLinePaginationDto> omdbOnLinePaginationDtoList = new ArrayList<>();
        omdbOnLinePaginationDtoList.add(omdbOnLinePaginationDto1);
        omdbOnLinePaginationDtoList.add(omdbOnLinePaginationDto2);
        return omdbOnLinePaginationDtoList;
    }
}
