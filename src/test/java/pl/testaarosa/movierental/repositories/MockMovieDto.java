package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.MovieDto;

import java.util.ArrayList;
import java.util.List;

public class MockMovieDto {

    private MockMovieWish mockMovieWish = new MockMovieWish();

    public MovieDto movieDtoBlueRay() {
        return new MovieDto(
                1L,
                "TestTitle1",
                "imdbID_1",
                "www.poster11",
                "bluray supplier",
                mockMovieWish.mockMovieWish());
    }

    public MovieDto movieDtoOnLine() {
        return new MovieDto(
                1L,
                "Online TestTitle1",
                "imdbID_O1",
                "www.Online-poster11",
                "On Line",
                mockMovieWish.mockMovieWish());
    }

    public MovieDto movieDtoDvd() {
        return new MovieDto(
                1L,
                "DvdMovie1",
                "DvdImdbID_1",
                "www.DvdPoster",
                "dvd supplier",
                mockMovieWish.mockMovieWish());
    }

    public MovieDto movieDtoDvdEqualsTest() {
        return new MovieDto(
                1L,
                "DvdMovie1",
                "DvdImdbID_1",
                "www.DvdPoster",
                "dvd supplier",
                mockMovieWish.mockMovieWish());
    }


    public List<MovieDto> movieDtoList() {
        List<MovieDto> movieDtoList = new ArrayList<>();
        movieDtoList.add(movieDtoOnLine());
        movieDtoList.add(movieDtoBlueRay());
        movieDtoList.add(movieDtoDvd());
        movieDtoList.add(movieDtoDvdEqualsTest());
        return movieDtoList;
    }
}
