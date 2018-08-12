package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.DvdMovieDetails;

import java.util.LinkedList;
import java.util.List;

public class MockDvdMovieDetails {

    public List<DvdMovieDetails> dvdMovieDetailsList() {
        DvdMovieDetails dvdMovieDetails1 = new DvdMovieDetails();
        dvdMovieDetails1.setId(1L);
        dvdMovieDetails1.setImdbID("DvdImdbID_1");
        dvdMovieDetails1.setTitle("DvdMovie1");
        dvdMovieDetails1.setCountryOfOrigin("Polska");
        dvdMovieDetails1.setType("comedy");
        dvdMovieDetails1.setPrice(11.2);
        dvdMovieDetails1.setPoster("www.DvdPoster");
        dvdMovieDetails1.setSupplier("ONE Supplier");

        DvdMovieDetails dvdMovieDetails2 = new DvdMovieDetails();
        dvdMovieDetails1.setId(2L);
        dvdMovieDetails1.setImdbID("DvdImdbID_2");
        dvdMovieDetails1.setTitle("DvdMovie2");
        dvdMovieDetails1.setCountryOfOrigin("USA");
        dvdMovieDetails1.setType("comedy");
        dvdMovieDetails1.setPrice(9.5);
        dvdMovieDetails1.setPoster("www.DvdPoster2");
        dvdMovieDetails1.setSupplier("ONE Supplier");

        List<DvdMovieDetails> dvdMovieDetailsList = new LinkedList<>();
        dvdMovieDetailsList.add(dvdMovieDetails1);
        dvdMovieDetailsList.add(dvdMovieDetails2);

        return dvdMovieDetailsList;
    }
}
