package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.DvdMovieDetails;

import java.util.LinkedList;
import java.util.List;

public class MockDvdMovieDetails {

    public List<DvdMovieDetails> dvdMovieDetailsList() {
        DvdMovieDetails dvdMovieDetails1 = new DvdMovieDetails();
        dvdMovieDetails1.setImdbID("DvdImdbID_1");
        dvdMovieDetails1.setTitle("DvdMovie1");
        dvdMovieDetails1.setCountryOfOrigin("Polska");
        dvdMovieDetails1.setType("comedy");
        dvdMovieDetails1.setPrice(11.2);
        dvdMovieDetails1.setPoster("http://goshico.com/allegro/questionmarksmall.png");
        dvdMovieDetails1.setSupplier("DVD MOVIE");

        DvdMovieDetails dvdMovieDetails2 = new DvdMovieDetails();
        dvdMovieDetails2.setImdbID("DvdImdbID_2");
        dvdMovieDetails2.setTitle("DvdMovie2");
        dvdMovieDetails2.setCountryOfOrigin("USA");
        dvdMovieDetails2.setType("comedy");
        dvdMovieDetails2.setPrice(9.5);
        dvdMovieDetails2.setPoster("http://goshico.com/allegro/questionmarksmall.png");
        dvdMovieDetails2.setSupplier("DVD MOVIE");

        DvdMovieDetails dvdMovieDetails2EqualsTest = new DvdMovieDetails();
        dvdMovieDetails2EqualsTest.setImdbID("DvdImdbID_2");
        dvdMovieDetails2EqualsTest.setTitle("DvdMovie2");
        dvdMovieDetails2EqualsTest.setCountryOfOrigin("USA");
        dvdMovieDetails2EqualsTest.setType("comedy");
        dvdMovieDetails2EqualsTest.setPrice(9.5);
        dvdMovieDetails2EqualsTest.setPoster("http://goshico.com/allegro/questionmarksmall.png");
        dvdMovieDetails2EqualsTest.setSupplier("DVD MOVIE");

        List<DvdMovieDetails> dvdMovieDetailsList = new LinkedList<>();
        dvdMovieDetailsList.add(dvdMovieDetails1);
        dvdMovieDetailsList.add(dvdMovieDetails2);
        dvdMovieDetailsList.add(dvdMovieDetails2EqualsTest);

        return dvdMovieDetailsList;
    }
}
