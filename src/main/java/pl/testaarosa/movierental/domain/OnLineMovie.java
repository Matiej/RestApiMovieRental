package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "ONLINE_MOVIES")
@DiscriminatorValue("ONLINE_MOVIES")
public class OnLineMovie extends Movie{

    private String year;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ONLINE_DET_ID")
    private OnLineMovieDetails onLineMovieDetails;

    public OnLineMovie() {
    }

    public OnLineMovie(String title, String year, String imdbID, String poster, String supplier) {
        super(title,imdbID,poster,supplier);
        this.year = year;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSupplier() {
        return "On Line";
    }

    public OnLineMovieDetails getOnLineMovieDetails() {
        return onLineMovieDetails;
    }

    public void setOnLineMovieDetails(OnLineMovieDetails onLineMovieDetails) {
        this.onLineMovieDetails = onLineMovieDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnLineMovie that = (OnLineMovie) o;
        return Objects.equals(year, that.year) &&
                Objects.equals(onLineMovieDetails, that.onLineMovieDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, onLineMovieDetails);
    }

    @Override
    public String toString() {
        return super.toString() + year + "\n" + getOnLineMovieDetails() +"\n" + getMovieWishList();
    }
}
