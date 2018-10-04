package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MockMovie {

    private MockMovieWish mockMovieWish = new MockMovieWish();

    public Movie movieBlueRay() {
        Movie movie = new Movie(
                "TestTitle1",
                "imdbID_1",
                "www.poster11",
                "bluray supplier");
        movie.setId(1L);
        movie.setMovieWishList(mockMovieWish.mockMovieWish());
        return movie;
    }

    public Movie movieOnLine() {
        Movie movie = new Movie(
                "Online TestTitle1",
                "imdbID_O1",
                "www.Online-poster11",
                "On line");

        movie.setId(1L);
        movie.setMovieWishList(mockMovieWish.mockMovieWish());
        return movie;
    }

    public Movie movieDvd() {
        Movie movie = new  Movie(
                "DvdMovie1",
                "DvdImdbID_1",
                "www.DvdPoster",
                "dvd supplier");
        movie.setId(1L);
        movie.setMovieWishList(mockMovieWish.mockMovieWish());
        return movie;
    }

    public List<Movie> movieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movieOnLine());
        movieList.add(movieBlueRay());
        movieList.add(movieDvd());
        return movieList;
    }

    public List<Movie> movieListEqualsTest() {
        Movie movie1 = new Movie(
                "TestTitle1",
                "imdbID_1",
                "www.poster11",
                "bluray supplier");
        movie1.setId(1L);
        movie1.setMovieWishList(mockMovieWish.mockMovieWish());

        Movie movie2 = new Movie(
                "Online TestTitle1",
                "imdbID_O1",
                "www.Online-poster11",
                "On line");

        movie2.setId(1L);
        movie2.setMovieWishList(mockMovieWish.mockMovieWish());

        Movie movie3 = new  Movie(
                "DvdMovie1",
                "DvdImdbID_1",
                "www.DvdPoster",
                "dvd supplier");
        movie3.setId(1L);
        movie3.setMovieWishList(mockMovieWish.mockMovieWish());
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie2);
        movieList.add(movie1);
        movieList.add(movie3);
        return movieList;
    }
}
