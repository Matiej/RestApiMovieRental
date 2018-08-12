package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("DVD_MOVIES")
public class DvdMovie extends Movie {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DVD_DET_ID")
    private DvdMovieDetails dvdMovieDetails;

    public DvdMovie() {
    }

    public DvdMovie(String title, String imdbID, String poster, String supplier) {
        super(title,imdbID,poster,supplier);
    }

    @Override
    public String getSupplier() {
        return "DVD supplier";
    }

    public DvdMovieDetails getDvdMovieDetails() {
        return dvdMovieDetails;
    }

    public void setDvdMovieDetails(DvdMovieDetails dvdMovieDetails) {
        this.dvdMovieDetails = dvdMovieDetails;
    }

    @Override
    public String toString() {
        return "DvdMovie{" + getTitle() +
                ", dvdMovieDetails=" + dvdMovieDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvdMovie dvdMovie = (DvdMovie) o;
        return Objects.equals(dvdMovieDetails, dvdMovie.dvdMovieDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dvdMovieDetails);
    }
}
