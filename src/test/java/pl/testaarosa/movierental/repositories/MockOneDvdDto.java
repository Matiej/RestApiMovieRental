package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OneDvdDto;

import java.util.ArrayList;
import java.util.List;

public class MockOneDvdDto {

    public List<OneDvdDto> oneDvdDtoList() {
        OneDvdDto oneDvdDto1 = new OneDvdDto.Builder()
                .countryOfOrigin("Polska")
                .filmGenre("comedy")
                .movieId("DvdImdbID_1")
                .price(11.2)
                .title("DvdMovie1")
                .build();
        OneDvdDto oneDvdDto2 = new OneDvdDto.Builder()
                .countryOfOrigin("USA")
                .filmGenre("comedy")
                .movieId("DvdImdbID_2")
                .price(9.5)
                .title("DvdMovie2")
                .build();
        OneDvdDto oneDvdDto2EqualsTtest = new OneDvdDto.Builder()
                .countryOfOrigin("USA")
                .filmGenre("comedy")
                .movieId("DvdImdbID_2")
                .price(9.5)
                .title("DvdMovie2")
                .build();
        List<OneDvdDto> oneDvdDtoList = new ArrayList<>();
        oneDvdDtoList.add(oneDvdDto1);
        oneDvdDtoList.add(oneDvdDto2);
        oneDvdDtoList.add(oneDvdDto2EqualsTtest);
        return oneDvdDtoList;
    }
}
