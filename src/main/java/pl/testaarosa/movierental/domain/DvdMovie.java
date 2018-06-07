package pl.testaarosa.movierental.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("DVD_MOVIES")
public class DvdMovie extends Movie {

    private String imdbID;
    private String title;
    private String poster;
    private String supplier;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DVD_DET_ID")
    private DvdMovieDetails dvdMovieDetails;

    public DvdMovie() {
    }

    public DvdMovie(String imdbID, String title, String poster, String supplier) {
        this.imdbID = imdbID;
        this.title = title;
        this.poster = poster;
        this.supplier = supplier;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getImdbID() {
        return imdbID;
    }

    @Override
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getPoster() {
        return poster;
    }

    @Override
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String getSupplier() {
        return supplier;
    }

    @Override
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
