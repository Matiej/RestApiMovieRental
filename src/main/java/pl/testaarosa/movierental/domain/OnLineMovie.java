package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "ONLINE_MOVIES")
@DiscriminatorValue("ONLINE_MOVIES")
public class OnLineMovie extends Movie{
    private String title;
    private String year;
    private String imdbID;
    private String poster;
    private String supplier;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    @JoinColumn(name = "ONLINE_DET_ID")
    private OnLineMovieDetails onLineMovieDetails;

    public OnLineMovie() {
    }

    public OnLineMovie(String title, String year, String imdbID, String poster, String supplier) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
    }



    public Long getId() {
        return super.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
        return "On Line";
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public OnLineMovieDetails getOnLineMovieDetails() {
        return onLineMovieDetails;
    }

    public void setOnLineMovieDetails(OnLineMovieDetails onLineMovieDetails) {
        this.onLineMovieDetails = onLineMovieDetails;
    }

    @Override
    public String toString() {
        return "BlueRayMovie{" +
                ", title='" + title + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                ", onLineMovieDetails=" + onLineMovieDetails;
    }
}
