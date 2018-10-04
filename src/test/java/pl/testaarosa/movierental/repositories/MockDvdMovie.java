package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.DvdMovie;

import java.util.LinkedList;
import java.util.List;

public class MockDvdMovie {

    private MockMovieWish mockMovieWish = new MockMovieWish();
    private MockDvdMovieDetails mockDvdMovieDetails = new MockDvdMovieDetails();

    public List<DvdMovie> dvdMovieList() {

        DvdMovie dvdMovie1 = new DvdMovie();
//        dvdMovie1.setId(1L);
        dvdMovie1.setTitle("DvdMovie1");
        dvdMovie1.setImdbID("DvdImdbID_1");
        dvdMovie1.setPoster("http://goshico.com/allegro/questionmarksmall.png");
        dvdMovie1.setSupplier("DVD MOVIE");
        dvdMovie1.setMovieWishList(mockMovieWish.mockMovieWish());
        dvdMovie1.setDvdMovieDetails(mockDvdMovieDetails.dvdMovieDetailsList().get(0));

        DvdMovie dvdMovie2 = new DvdMovie();
        dvdMovie2.setTitle("DvdMovie2");
        dvdMovie2.setImdbID("DvdImdbID_2");
        dvdMovie2.setPoster("http://goshico.com/allegro/questionmarksmall.png");
        dvdMovie2.setSupplier("DVD MOVIE");
        dvdMovie2.setMovieWishList(mockMovieWish.mockMovieWish());
        dvdMovie2.setDvdMovieDetails(mockDvdMovieDetails.dvdMovieDetailsList().get(1));

        DvdMovie dvdMovie2EqualsTest = new DvdMovie();
        dvdMovie2EqualsTest.setTitle("DvdMovie2");
        dvdMovie2EqualsTest.setImdbID("DvdImdbID_2");
        dvdMovie2EqualsTest.setPoster("http://goshico.com/allegro/questionmarksmall.png");
        dvdMovie2EqualsTest.setSupplier("DVD MOVIE");
        dvdMovie2EqualsTest.setMovieWishList(mockMovieWish.mockMovieWish());
        dvdMovie2EqualsTest.setDvdMovieDetails(mockDvdMovieDetails.dvdMovieDetailsList().get(1));

        List<DvdMovie> dvdMovieList = new LinkedList<>();
        dvdMovieList.add(dvdMovie1);
        dvdMovieList.add(dvdMovie2);
        dvdMovieList.add(dvdMovie2EqualsTest);

        return dvdMovieList;
    }
}
