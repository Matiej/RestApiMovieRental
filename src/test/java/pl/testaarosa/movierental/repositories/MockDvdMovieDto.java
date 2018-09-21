package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.DvdMovieDto;

import java.util.LinkedList;
import java.util.List;

public class MockDvdMovieDto {

    private MockMovieWish mockMovieWish = new MockMovieWish();
    private MockDvdMovieDetails mockDvdMovieDetails = new MockDvdMovieDetails();

    public List<DvdMovieDto> dvdMovieDtoList() {
        DvdMovieDto dvdMovie1 = new DvdMovieDto(
                1L,
                "DvdMovie1",
                "DvdImdbID_1",
                "www.DvdPoster",
                "DVD supplier",
                mockDvdMovieDetails.dvdMovieDetailsList().get(0));

        DvdMovieDto dvdMovie2 = new DvdMovieDto(
                2L,
                "DvdMovie2",
                "DvdImdbID_2",
                "www.DvdPoster2",
                "DVD supplier",
                mockDvdMovieDetails.dvdMovieDetailsList().get(1));

        List<DvdMovieDto> dvdMovieList = new LinkedList<>();
        dvdMovieList.add(dvdMovie1);
        dvdMovieList.add(dvdMovie2);
        return dvdMovieList;
    }
}
