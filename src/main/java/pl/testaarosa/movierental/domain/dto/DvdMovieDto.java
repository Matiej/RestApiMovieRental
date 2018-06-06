package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.DvdMovieDetails;

import java.util.Optional;

public class DvdMovieDto {

    private Long id;
    private String title;
    private String imdbID;
//    private final String countryOfOrigin;
//    private final String type;
//    private double price;
    private String poster;
    private String supplier;
    private DvdMovieDetails dvdMovieDetails;

    public DvdMovieDto(Long id, String title, String imdbID, String poster, String supplier, DvdMovieDetails dvdMovieDetails) {
        this.id = id;
        this.title = title;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
        this.dvdMovieDetails = dvdMovieDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public DvdMovieDetails getDvdMovieDetails() {
        return dvdMovieDetails;
    }

    public void setDvdMovieDetails(DvdMovieDetails dvdMovieDetails) {
        this.dvdMovieDetails = dvdMovieDetails;
    }
}
