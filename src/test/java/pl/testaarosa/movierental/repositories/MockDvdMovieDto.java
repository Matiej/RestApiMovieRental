package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.DvdMovieDto;

import java.util.LinkedList;
import java.util.List;

public class MockDvdMovieDto {

    private MockMovieWish mockMovieWish = new MockMovieWish();
    private MockDvdMovieDetails mockDvdMovieDetails = new MockDvdMovieDetails();

    public List<DvdMovieDto> dvdMovieDtoList() {
        DvdMovieDto dvdMovie1 = new DvdMovieDto(
                null,
                "DvdMovie1",
                "DvdImdbID_1",
                "http://goshico.com/allegro/questionmarksmall.png",
                "DVD supplier",
                mockDvdMovieDetails.dvdMovieDetailsList().get(0));

        DvdMovieDto dvdMovie2 = new DvdMovieDto(
                null,
                "DvdMovie2",
                "DvdImdbID_2",
                "http://goshico.com/allegro/questionmarksmall.png",
                "DVD supplier",
                mockDvdMovieDetails.dvdMovieDetailsList().get(1));

        DvdMovieDto dvdMovie3 = new DvdMovieDto(
                null,
                "DvdMovie2",
                "DvdImdbID_2",
                "http://goshico.com/allegro/questionmarksmall.png",
                "DVD supplier",
                mockDvdMovieDetails.dvdMovieDetailsList().get(1));

        List<DvdMovieDto> dvdMovieList = new LinkedList<>();
        dvdMovieList.add(dvdMovie1);
        dvdMovieList.add(dvdMovie2);
        dvdMovieList.add(dvdMovie3);
        return dvdMovieList;
    }
}
