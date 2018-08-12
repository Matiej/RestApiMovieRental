package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("BLUE_RAY_MOVIES")
public class BlueRayMovie extends Movie{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BLUE_DET_ID")
    private BlueRayMovieDetails blueRayMovieDetails;

    public BlueRayMovie() {
    }

   public BlueRayMovie(String title, String imdbID, String poster, String supplier){
        super(title,imdbID,poster,supplier);
   }

    @Override
    public String getSupplier() {
        return "BluRay supplier";
    }

    public BlueRayMovieDetails getBlueRayMovieDetails() {
        return blueRayMovieDetails;
    }

    public void setBlueRayMovieDetails(BlueRayMovieDetails blueRayMovieDetails) {
        this.blueRayMovieDetails = blueRayMovieDetails;
    }

    @Override
    public String toString() {
        return "BlueRayMovie{" +
                "blueRayMovieDetails=" + blueRayMovieDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlueRayMovie that = (BlueRayMovie) o;
        return Objects.equals(blueRayMovieDetails, that.blueRayMovieDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blueRayMovieDetails);
    }
}

